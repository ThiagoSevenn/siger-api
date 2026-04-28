package br.com.siger.siger_api.service;

import br.com.siger.siger_api.enums.EnumUserStatus;
import br.com.siger.siger_api.global.service.GenericBaseService;
import br.com.siger.siger_api.model.User;
import br.com.siger.siger_api.repository.UserRepository;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GenericBaseService<UserRepository, User, Long> {

    private final PasswordEncoder passwordEncoder;

    public UserService(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User create(User user){
        String encriptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encriptedPassword);
        user.setStatus(EnumUserStatus.ATIVO);
        user.setCreatedBy(user.getEmail());
        user.setUpdatedBy(user.getEmail());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        user.setLastLogin(LocalDateTime.now());
        return repository.save(user);
    }

}
