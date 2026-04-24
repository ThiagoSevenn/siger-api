package br.com.siger.siger_api.controller;

import br.com.siger.siger_api.service.IaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Conexão - Ia")
@RestController
@RequestMapping("/ia")
public class IaController {

    private final IaService iaService;

    public IaController(IaService iaService) {
        this.iaService = iaService;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody String prompt) {
        String output = iaService.generateOutpuFromPrompt(prompt);
        return ResponseEntity.ok().body(output);
    }
}
