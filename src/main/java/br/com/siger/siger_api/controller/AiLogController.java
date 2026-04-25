package br.com.siger.siger_api.controller;

import br.com.siger.siger_api.global.controller.GenericBaseController;
import br.com.siger.siger_api.model.AiLog;
import br.com.siger.siger_api.service.AiLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "AiLog")
@RestController
@RequestMapping("/aiLog")
public class AiLogController extends GenericBaseController<AiLogService, AiLog, Long> {
}
