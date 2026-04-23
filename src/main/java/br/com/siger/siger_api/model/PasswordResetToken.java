package br.com.siger.siger_api.model;

import java.time.LocalDateTime;

import br.com.siger.siger_api.global.model.GenericBaseModel;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "tb_password_reset_token", schema = "bd_siger")
public class PasswordResetToken extends GenericBaseModel<Long> {

    @Column(name = "token", nullable = false, unique = true)
    private String token;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "expires_at", nullable = false)
    private LocalDateTime expiresAt;

    @Column(name = "used", nullable = false)
    private boolean used;

}
