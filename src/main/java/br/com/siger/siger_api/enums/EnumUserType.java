package br.com.siger.siger_api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumUserType {
    ADMIN("Admin"),
    ORGANIZADOR("Organizador"),
    PARTICIPANTE("Participante");

    private String description;
}
