package br.com.siger.siger_api.dto.meeting;

import java.time.LocalDateTime;

import br.com.siger.siger_api.enums.EnumMeetingStatus;
import br.com.siger.siger_api.model.Meeting;

public record MeetingResponseDTO(
    Long id,
    String title,
    String description,
    String location,
    LocalDateTime meetingDate,
    Integer duration,
    EnumMeetingStatus status,
    Long organizerId,
    String organizerName,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {

    public static MeetingResponseDTO fromEntity(Meeting meeting){
        return new MeetingResponseDTO(
            meeting.getId(),
            meeting.getTitle(),
            meeting.getDescription(),
            meeting.getLocation(),
            meeting.getMeetingDate(),
            meeting.getDuration(),
            meeting.getStatus(),
            meeting.getUser() != null ? meeting.getUser().getId() : null,
            meeting.getUser() != null ? meeting.getUser().getName() : null,
            meeting.getCreatedAt(),
            meeting.getUpdatedAt()
        );
    }

}