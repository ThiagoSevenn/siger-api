package br.com.siger.siger_api.repository;

import br.com.siger.siger_api.model.MeetingMinutes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingMinutesRepository extends JpaRepository<MeetingMinutes, Long> {
}
