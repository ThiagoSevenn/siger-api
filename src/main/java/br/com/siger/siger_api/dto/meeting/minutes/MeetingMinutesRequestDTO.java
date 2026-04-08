package br.com.siger.siger_api.dto.meeting.minutes;

public record MeetingMinutesRequestDTO(Long meetingMinutesId, Long meetingId, String objectives,
                                       String notes, String decision) {
}
