package br.com.siger.siger_api.repository;

import br.com.siger.siger_api.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
