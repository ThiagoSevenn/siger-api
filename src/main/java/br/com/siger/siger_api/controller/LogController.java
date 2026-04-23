package br.com.siger.siger_api.controller;

import br.com.siger.siger_api.model.Log;
import br.com.siger.siger_api.dto.log.LogRequestDTO;
import br.com.siger.siger_api.service.LogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

@Tag(name = "Log")
@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    LogService logService ;

    @PostMapping
    public ResponseEntity<Log> create(@RequestBody LogRequestDTO body) {
        Log newLog = this.logService.logInsert(body.operation());
        return ResponseEntity.ok().body(newLog);
    }
}
