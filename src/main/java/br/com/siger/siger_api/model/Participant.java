package br.com.siger.siger_api.model;

import br.com.siger.siger_api.enums.EnumParticipantParticipation;
import br.com.siger.siger_api.enums.EnumParticipantRole;
import br.com.siger.siger_api.global.model.GenericBaseModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "tb_participant", schema = "bd_siger")
public class Participant extends GenericBaseModel<Long> {

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

    @NotNull
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private EnumParticipantRole role;

    @NotNull
    @Column(name = "participation")
    @Enumerated(EnumType.STRING)
    private EnumParticipantParticipation participation;

    @OneToMany(mappedBy = "participant")
    private List<Topic> topics;
}
