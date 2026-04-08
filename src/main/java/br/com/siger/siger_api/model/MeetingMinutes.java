package br.com.siger.siger_api.model;

import java.util.List;

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
@Table(name = "tb_meeting_minutes", schema = "bd_siger")
public class MeetingMinutes extends GenericBaseModel<Long> {

    @NotNull
    @Size(max = 100)
    @Column(name = "objectives")
    private String objectives;

    @NotNull
    @Size(max = 255)
    @Column(name = "notes")
    private String notes;

    @NotNull
    @Size(max = 255)
    @Column(name = "decision")
    private String decision;

    @OneToOne
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

    @OneToMany(mappedBy = "meetingMinutes")
    @OrderBy("orderIndex ASC")
    private List<Topic> topics;
}
