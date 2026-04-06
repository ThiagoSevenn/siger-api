package br.com.siger.siger_api.repositories;

import br.com.siger.siger_api.domain.meeting_minutes.MeetingMinutes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MeetingMinutesRepository extends JpaRepository<MeetingMinutes, UUID> {
}
