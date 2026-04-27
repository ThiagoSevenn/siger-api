package br.com.siger.siger_api.repository;

import br.com.siger.siger_api.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
