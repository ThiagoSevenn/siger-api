package br.com.siger.siger_api.controller;

import br.com.siger.siger_api.dto.meeting.MeetingRequestDTO;
import br.com.siger.siger_api.dto.meeting.MeetingResponseDTO;
import br.com.siger.siger_api.dto.meeting.MeetingUpdateDTO;
import br.com.siger.siger_api.global.controller.GenericBaseController;
import br.com.siger.siger_api.model.Meeting;
import br.com.siger.siger_api.service.MeetingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Reunião")
@RestController
@RequestMapping("/meeting")
public class MeetingController extends GenericBaseController<MeetingService, Meeting, Long> {

    @PostMapping("/create")
    @Operation(description = "Criação de uma nova reunião")
    public ResponseEntity<MeetingResponseDTO> create(@Valid @RequestBody MeetingRequestDTO dto){
        Meeting meeting = service.createFromDTO(dto);
        return ResponseEntity.status(HttpStatus.SC_CREATED).body(MeetingResponseDTO.fromEntity(meeting));
    }

    @PutMapping("/update/{id:[0-9]+}")
    @Operation(description = "Edição de uma reunião existente")
    public ResponseEntity<MeetingResponseDTO> update(@PathVariable Long id, @Valid @RequestBody MeetingUpdateDTO dto) {
        Meeting meeting = service.updateFromDTO(id, dto);
        return ResponseEntity.ok(MeetingResponseDTO.fromEntity(meeting));
    }

    @PatchMapping("/cancel/{id:[0-9]+}")
    @Operation(description = "Cancelamento de uma reunião")
    public ResponseEntity<MeetingResponseDTO> cancel(@PathVariable Long id) {
        Meeting meeting = service.cancel(id);
        return ResponseEntity.ok(MeetingResponseDTO.fromEntity(meeting));
    }

}
