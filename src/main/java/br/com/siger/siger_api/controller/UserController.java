package br.com.siger.siger_api.controller;

import br.com.siger.siger_api.global.controller.GenericBaseController;
import br.com.siger.siger_api.model.User;
import br.com.siger.siger_api.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Usuário")
@RestController
@RequestMapping("/api/user")
public class UserController extends GenericBaseController<UserService, User, Long> {
}
