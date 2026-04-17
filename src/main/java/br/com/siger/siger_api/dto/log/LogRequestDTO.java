package br.com.siger.siger_api.dto.log;


public record LogRequestDTO(Long logId ,String operation, String userName, Long date) {
}
