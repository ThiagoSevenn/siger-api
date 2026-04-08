package br.com.siger.siger_api.dto.user;


public record UserRequestDTO(Long userId, Long createdAt, Long updatedAt, Long lastLogin,
                             String name, String email, String password,
                             String cpf, String phone, String createdBy,
                             String updatedBy, String status, String type) {
}
