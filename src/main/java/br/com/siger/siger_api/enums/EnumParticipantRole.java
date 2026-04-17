package br.com.siger.siger_api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumParticipantRole {
    ORGANIZADOR("organizador"),
    PARTICIPANTE("participante"),
    PALESTRANTE("palestrante");

    private String description;
}
