package br.com.siger.siger_api.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "tb_log", schema = "bd_siger")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(name = "operation")
    private String operation;

    @NotNull
    @Size(max = 100)
    @Column(name = "user_name")
    private String userName;

    @NotNull
    @Column(name = "date")
    private LocalDateTime date;

    public Log(String operation, String userName) {
        this.date = LocalDateTime.now();
        this.operation = operation;
        this.userName = userName;
    }
}
