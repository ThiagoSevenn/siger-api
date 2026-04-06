package br.com.siger.siger_api.repositories;

import br.com.siger.siger_api.domain.topic.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TopicRepository extends JpaRepository<Topic, UUID> {
}
