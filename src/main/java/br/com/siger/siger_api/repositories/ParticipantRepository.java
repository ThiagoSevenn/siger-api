package br.com.siger.siger_api.repositories;

import br.com.siger.siger_api.domain.partcipant.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParticipantRepository extends JpaRepository<Participant, UUID> {
}
