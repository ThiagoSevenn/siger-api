package br.com.siger.siger_api.domain.log;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_log", schema = "bd_siger")
public class Log {
    @Id
    @GeneratedValue
    private UUID id;

    private String operation;
    private String userName;
    
    private Date date;
}
