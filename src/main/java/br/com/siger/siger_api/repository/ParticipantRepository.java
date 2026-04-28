package br.com.siger.siger_api.repository;

import br.com.siger.siger_api.model.Participant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

    boolean existsByUserIdAndMeetingId(Long userId, Long meetingId);
 
    List<Participant> findByMeetingId(Long meetingId);

}
