package br.com.siger.siger_api.repository;

import br.com.siger.siger_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
