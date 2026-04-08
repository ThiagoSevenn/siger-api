package br.com.siger.siger_api.repository;

import br.com.siger.siger_api.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
