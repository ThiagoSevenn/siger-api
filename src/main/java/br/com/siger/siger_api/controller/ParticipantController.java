package br.com.siger.siger_api.controller;

import br.com.siger.siger_api.global.controller.GenericBaseController;
import br.com.siger.siger_api.model.Participant;
import br.com.siger.siger_api.service.ParticipantService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Participante")
@RestController
@RequestMapping("/participant")
public class ParticipantController extends GenericBaseController<ParticipantService, Participant, Long> {
}
