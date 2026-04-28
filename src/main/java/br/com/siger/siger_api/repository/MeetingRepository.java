package br.com.siger.siger_api.repository;

import br.com.siger.siger_api.enums.EnumMeetingStatus;
import br.com.siger.siger_api.model.Meeting;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {

    @Query("SELECT m FROM Meeting m WHERE m.status = :status AND m.meetingDate <= :now")
    List<Meeting> findMeetingsToStart(@Param("status") EnumMeetingStatus status,
                                      @Param("now") LocalDateTime now);
 
    @Query("SELECT m FROM Meeting m WHERE m.status = :status AND FUNCTION('TIMESTAMPADD', MINUTE, m.duration, m.meetingDate) <= :now")
    List<Meeting> findMeetingsToFinish(@Param("status") EnumMeetingStatus status,
                                       @Param("now") LocalDateTime now);

}
