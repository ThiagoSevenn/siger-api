package br.com.siger.siger_api.dto.participant;
 
import jakarta.validation.constraints.NotNull;
 
public record ParticipantRequestDTO(
 
        @NotNull(message = "O ID do usuário é obrigatório")
        Long userId,
 
        @NotNull(message = "O ID da reunião é obrigatório")
        Long meetingId,
 
        @NotNull(message = "O papel do participante é obrigatório")
        String role
) {
}