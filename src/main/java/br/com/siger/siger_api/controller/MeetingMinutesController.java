package br.com.siger.siger_api.controller;

import br.com.siger.siger_api.global.controller.GenericBaseController;
import br.com.siger.siger_api.model.MeetingMinutes;
import br.com.siger.siger_api.service.MeetingMinutesService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Ata da Reunião")
@RestController
@RequestMapping("/api/meeting/minutes")
public class MeetingMinutesController extends GenericBaseController<MeetingMinutesService, MeetingMinutes, Long> {
}
