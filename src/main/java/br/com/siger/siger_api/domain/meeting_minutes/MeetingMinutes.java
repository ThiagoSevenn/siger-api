package br.com.siger.siger_api.domain.meeting_minutes;

import java.util.List;

import br.com.siger.siger_api.domain.meeting.Meeting;
import br.com.siger.siger_api.domain.topic.Topic;
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
@Table(name = "tb_meeting_minutes", schema = "bd_siger")
public class MeetingMinutes {
    @Id
    @GeneratedValue
    private Long id;

    private String objectives;
    private String agenda;  

    @OneToOne
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

    @OneToMany(mappedBy = "meetingMinutes")
    List<Topic> topics;
}
