package br.com.siger.siger_api.dto.meeting;

public record MeetingRequestDTO(Long meetingId, Long userId, Long createdAt,
                                Long updatedAt, Long meetingDate, String title,
                                String description, String location, Integer duration,
                                String status) {
}
