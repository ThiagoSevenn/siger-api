package br.com.siger.siger_api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumTaskStatus {
    NAO_INICIADO("Não iniciado"),
    EM_ANDAMENTO("Em andamento"),
    CONCLUIDO("Concluído");

    private String descprition;
}
