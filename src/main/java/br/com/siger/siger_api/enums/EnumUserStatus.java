package br.com.siger.siger_api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumUserStatus {
    ATIVO("Ativo"),
    INATIVO("Inativo");

    private String description;
}
