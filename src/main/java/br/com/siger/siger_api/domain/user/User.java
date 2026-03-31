package br.com.siger.siger_api.domain.user;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

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
@Table(name = "tb_user", schema = "bd_siger")
public class User implements Serializable {
    @Id
    @GeneratedValue
    private UUID id;

    private Date registrationDate;
    private Date modificationDate;

    private String name;
    private String email;
    private String password;
    private String cpf;
    private String status;
    private String type;
    private String registrationUser;
    private String modificationUser;
}
