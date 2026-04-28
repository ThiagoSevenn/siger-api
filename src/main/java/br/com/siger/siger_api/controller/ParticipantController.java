package br.com.siger.siger_api.controller;

import br.com.siger.siger_api.dto.participant.ParticipantRequestDTO;
import br.com.siger.siger_api.dto.participant.ParticipantResponseDTO;
import br.com.siger.siger_api.global.controller.GenericBaseController;
import br.com.siger.siger_api.model.Participant;
import br.com.siger.siger_api.service.ParticipantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Participante")
@RestController
@RequestMapping("/participant")
public class ParticipantController extends GenericBaseController<ParticipantService, Participant, Long> {

    @PostMapping("/add")
    @Operation(description = "Adicionar participante a uma reuniao")
    public ResponseEntity<ParticipantResponseDTO> add(@Valid @RequestBody ParticipantRequestDTO dto) {
        Participant participant = service.addToMeeting(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ParticipantResponseDTO.fromEntity(participant));
    }
 
    @GetMapping("/meeting/{meetingId:[0-9]+}")
    @Operation(description = "Listar participantes de uma reuniao")
    public ResponseEntity<List<ParticipantResponseDTO>> findByMeeting(@PathVariable Long meetingId) {
        List<ParticipantResponseDTO> participants = service.findByMeeting(meetingId)
                .stream()
                .map(ParticipantResponseDTO::fromEntity)
                .toList();
        return ResponseEntity.ok(participants);
    }

}
