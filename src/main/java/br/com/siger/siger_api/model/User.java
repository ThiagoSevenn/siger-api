package br.com.siger.siger_api.model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.siger.siger_api.enums.EnumUserStatus;
import br.com.siger.siger_api.enums.EnumUserType;
import br.com.siger.siger_api.global.model.GenericBaseModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "tb_user", schema = "bd_siger")
public class User extends GenericBaseModel<Long> implements UserDetails{

    @NotNull
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @NotNull
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @NotNull
    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @NotNull
    @Size(max = 100)
    @Column(name = "name")
    private String name;

    @NotNull
    @Size(max = 100)
    @Column(name = "email")
    private String email;

    @NotNull
    @Size(max = 255)
    @Column(name = "password")
    private String password;

    @NotNull
    @Size(min = 11, max = 11)
    @Column(name = "cpf")
    private String cpf;

    @Size(min = 11, max = 11)
    @Column(name = "phone")
    private String phone;

    @NotNull
    @Size(max = 100)
    @Column(name = "created_by")
    private String createdBy;

    @NotNull
    @Size(max = 100)
    @Column(name = "updated_by")
    private String updatedBy;

    @NotNull
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private EnumUserStatus status;

    @NotNull
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private EnumUserType type;

    @OneToMany(mappedBy = "user")
    private List<Meeting> meeting;

    @OneToOne(mappedBy = "user")
    private Participant participant;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (type == EnumUserType.ADMIN)
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_ORGANIZADOR"));
        else
            return List.of(new SimpleGrantedAuthority("ROLE_ORGANIZADOR"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword(){
        return password;
    }

}
