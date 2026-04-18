package br.com.siger.siger_api.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.siger.siger_api.model.PasswordResetToken;
import br.com.siger.siger_api.model.User;
import br.com.siger.siger_api.repository.PasswordResetTokenRepository;
import br.com.siger.siger_api.repository.UserRepository;

@Service
public class PasswordResetService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordResetTokenRepository tokenRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void sendResetEmail(String email) {
        User user = (User) userRepository.findByEmail(email);
        if (user == null) {
            return;
        }

        tokenRepository.deleteByUserId(user.getId());

        String token = UUID.randomUUID().toString();

        PasswordResetToken resetToken = PasswordResetToken.builder()
                .token(token)
                .user(user)
                .expiresAt(LocalDateTime.now().plusHours(1))
                .used(false)
                .build();

        tokenRepository.save(resetToken);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Recuperação de senha - SIGER");
        message.setText("Olá, " + user.getName() + "!\n\n"
                + "Recebemos uma solicitação para redefinir a senha da sua conta.\n\n"
                + "Use o token abaixo para redefinir sua senha (válido por 1 hora):\n\n"
                + token + "\n\n"
                + "Se você não solicitou a recuperação de senha, ignore este e-mail.\n\n"
                + "Equipe SIGER");

        mailSender.send(message);
    }

    @Transactional
    public void resetPassword(String token, String newPassword) {
        PasswordResetToken resetToken = tokenRepository.findByToken(token)
                .orElseThrow(() -> new IllegalArgumentException("Token inválido."));

        if (resetToken.isUsed()) {
            throw new IllegalArgumentException("Token já utilizado.");
        }

        if (resetToken.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Token expirado.");
        }

        User user = resetToken.getUser();
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);

        resetToken.setUsed(true);
        tokenRepository.save(resetToken);

        SimpleMailMessage confirmation = new SimpleMailMessage();
        confirmation.setTo(user.getEmail());
        confirmation.setSubject("Senha alterada com sucesso - SIGER");
        confirmation.setText("Olá, " + user.getName() + "!\n\n"
                + "Sua senha foi alterada com sucesso.\n\n"
                + "Se você não realizou essa alteração, entre em contato com o suporte imediatamente.\n\n"
                + "Equipe SIGER");

        mailSender.send(confirmation);
    }

}
