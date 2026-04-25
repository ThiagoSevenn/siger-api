package br.com.siger.siger_api.service;

import br.com.siger.siger_api.global.service.GenericBaseService;
import br.com.siger.siger_api.model.AiLog;
import br.com.siger.siger_api.repository.AiLogRepository;
import org.springframework.beans.factory.annotation.Value;

import com.google.genai.types.GenerateContentResponse;
import com.google.genai.Client;
import org.springframework.stereotype.Service;

@Service
public class AiLogService extends GenericBaseService<AiLogRepository, AiLog, Long> {
    private Client client;

    private String model = "gemini-2.5-flash-lite";
    public AiLogService(@Value("${spring.gemini.api.key}") String apiKey) {
        client = Client.builder()
                .apiKey(apiKey)
                .build();
    };

    public String generateOutpuFromPrompt(String prompt) {
        GenerateContentResponse response =
                client.models.generateContent(model, prompt, null);

        System.out.println(response.text());
        return response.text();
    }
}
