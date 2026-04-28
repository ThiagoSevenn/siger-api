package br.com.siger.siger_api.dto.participant;

import br.com.siger.siger_api.enums.EnumParticipantParticipation;
import br.com.siger.siger_api.enums.EnumParticipantRole;
import br.com.siger.siger_api.model.Participant;

public record ParticipantResponseDTO(
        Long id,
        Long userId,
        String userName,
        String userEmail,
        Long meetingId,
        String meetingTitle,
        EnumParticipantRole role,
        EnumParticipantParticipation participation
) {
    public static ParticipantResponseDTO fromEntity(Participant p) {
        return new ParticipantResponseDTO(
                p.getId(),
                p.getUser() != null ? p.getUser().getId() : null,
                p.getUser() != null ? p.getUser().getName() : null,
                p.getUser() != null ? p.getUser().getEmail() : null,
                p.getMeeting() != null ? p.getMeeting().getId() : null,
                p.getMeeting() != null ? p.getMeeting().getTitle() : null,
                p.getRole(),
                p.getParticipation()
        );
    }
}