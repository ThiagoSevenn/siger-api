package br.com.siger.siger_api.model;

import br.com.siger.siger_api.global.model.GenericBaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_ai_log", schema = "bd_siger")
public class AiLog extends GenericBaseModel<Long> {

    @NotNull
    @Size(max = 255)
    @Column(name = "input")
    private String input;

    @NotNull
    @Size(max = 1000)
    @Column(name = "output")
    private String output;

    @NotNull
    @Column(name = "usefull")
    private Boolean usefull;
}
