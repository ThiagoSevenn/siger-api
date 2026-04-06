package br.com.siger.siger_api.repositories;

import br.com.siger.siger_api.domain.meeting.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MeetingRepository extends JpaRepository<Meeting, UUID> {
}
