package br.com.siger.siger_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.siger.siger_api.dto.auth.ForgotPasswordDTO;
import br.com.siger.siger_api.dto.auth.ResetPasswordDTO;
import br.com.siger.siger_api.dto.user.AuthDTO;
import br.com.siger.siger_api.dto.user.LoginResponseDTO;
import br.com.siger.siger_api.model.User;
import br.com.siger.siger_api.service.PasswordResetService;
import br.com.siger.siger_api.service.TokenService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private PasswordResetService passwordResetService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthDTO data) {
        var emailPassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(emailPassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody @Valid ForgotPasswordDTO data) {
        passwordResetService.sendResetEmail(data.email());
        return ResponseEntity.ok("Se o e-mail estiver cadastrado, você receberá as instruções em breve.");
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody @Valid ResetPasswordDTO data) {
        passwordResetService.resetPassword(data.token(), data.newPassword());
        return ResponseEntity.ok("Senha redefinida com sucesso.");
    }

}
