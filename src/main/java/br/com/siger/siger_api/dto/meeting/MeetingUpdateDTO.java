package br.com.siger.siger_api.dto.meeting;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record MeetingUpdateDTO(

    @NotNull(message = "A data da reunião é obrigatória")
        @Future(message = "A data da reunião deve ser no futuro")
        LocalDateTime meetingDate,
 
        @NotBlank(message = "O título é obrigatório")
        @Size(max = 100, message = "O título deve ter no máximo 100 caracteres")
        String title,
 
        @NotBlank(message = "A descrição é obrigatória")
        @Size(max = 255, message = "A descrição deve ter no máximo 255 caracteres")
        String description,
 
        @NotBlank(message = "O local é obrigatório")
        @Size(max = 100, message = "O local deve ter no máximo 100 caracteres")
        String location,
 
        @NotNull(message = "A duração é obrigatória")
        @Positive(message = "A duração deve ser um valor positivo (em minutos)")
        Integer duration,
 
        @NotNull(message = "O status é obrigatório")
        String status
        
) {
    
}
