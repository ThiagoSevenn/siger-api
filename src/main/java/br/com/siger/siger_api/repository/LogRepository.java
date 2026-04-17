package br.com.siger.siger_api.repository;

import br.com.siger.siger_api.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Long> {
}
