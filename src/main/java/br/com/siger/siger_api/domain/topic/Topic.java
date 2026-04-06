package br.com.siger.siger_api.domain.topic;

import br.com.siger.siger_api.domain.meeting_minutes.MeetingMinutes;
import br.com.siger.siger_api.enums.EnumTopicPriority;
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
@Table(name = "tb_topic", schema = "bd_siger")
public class Topic {
    @Id
    @GeneratedValue
    private UUID id;

    private Integer timer;

    private Boolean concluded;

    @ManyToOne
    @JoinColumn(name = "meeting_minutes_id")
    private MeetingMinutes meetingMinutes;

    private EnumTopicPriority priority;
}
