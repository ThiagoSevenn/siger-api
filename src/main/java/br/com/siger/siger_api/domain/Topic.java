package br.com.siger.siger_api.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_topic", schema = "bd_siger")
public class Topic {
    @Id
    @GeneratedValue
    private Long id;

    private Integer timer;

    private String priority;

    private Boolean concluded;
}
