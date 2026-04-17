package br.com.siger.siger_api.repository;

import br.com.siger.siger_api.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
}
