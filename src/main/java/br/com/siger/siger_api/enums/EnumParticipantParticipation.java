package br.com.siger.siger_api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumParticipantParticipation {
    NAO_PARTICIPOU("Não participou"),
    PARTICIPOU("Participou"),
    SIM("Sim"),
    NAO("Não"),
    TALVEZ("Talvez");


    private String description;
}
