package br.com.siger.siger_api.controller;

import br.com.siger.siger_api.global.controller.GenericBaseController;
import br.com.siger.siger_api.model.Meeting;
import br.com.siger.siger_api.service.MeetingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Reunião")
@RestController
@RequestMapping("/meeting")
public class MeetingController extends GenericBaseController<MeetingService, Meeting, Long> {
}
