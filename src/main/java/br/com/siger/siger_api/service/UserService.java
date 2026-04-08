package br.com.siger.siger_api.service;

import br.com.siger.siger_api.global.service.GenericBaseService;
import br.com.siger.siger_api.model.User;
import br.com.siger.siger_api.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GenericBaseService<UserRepository, User, Long> {
}
