package br.com.siger.siger_api.model;

import br.com.siger.siger_api.enums.EnumTopicPriority;
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
@Table(name = "tb_topic", schema = "bd_siger")
public class Topic extends GenericBaseModel<Long>{

    @NotNull
    @Size(max = 100)
    @Column(name = "title")
    private String title;

    @Column(name = "timer")
    private Integer timer;

    @Column(name = "order_index")
    private Integer orderIndex;

    @NotNull
    @Column(name = "concluded")
    private Boolean concluded;

    @ManyToOne
    @JoinColumn(name = "meeting_minutes_id")
    private MeetingMinutes meetingMinutes;

    @ManyToOne
    @JoinColumn(name = "responsible_id")
    private Participant participant;

    @NotNull
    @Column(name = "priority")
    @Enumerated(EnumType.STRING)
    private EnumTopicPriority priority;
}
