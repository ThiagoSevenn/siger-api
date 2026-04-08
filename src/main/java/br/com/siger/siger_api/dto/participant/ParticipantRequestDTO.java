package br.com.siger.siger_api.dto.participant;

public record ParticipantRequestDTO(Long participantId, Long userId, Long meetingId,
                                   String role, String participation) {
}
