package br.com.siger.siger_api.domain.partcipant;

import br.com.siger.siger_api.domain.meeting.Meeting;
import br.com.siger.siger_api.domain.user.User;
import br.com.siger.siger_api.enums.EnumParticipantParticipation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_participant", schema = "bd_siger")
public class Participant {
    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

    private EnumParticipantParticipation participation;
}
