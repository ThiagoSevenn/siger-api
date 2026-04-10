package br.com.siger.siger_api.model;

import java.time.LocalDateTime;
import java.util.List;

import br.com.siger.siger_api.enums.EnumMeetingStatus;
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
@Table(name = "tb_meeting", schema = "bd_siger")
public class Meeting extends GenericBaseModel<Long> {

    @NotNull
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @NotNull
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @NotNull
    @Column(name = "meeting_date")
    private LocalDateTime meetingDate;

    @NotNull
    @Size(max = 100)
    @Column(name = "title")
    private String title;

    @NotNull
    @Size(max = 255)
    @Column(name = "description")
    private String description;

    @NotNull
    @Size(max = 100)
    @Column(name = "location")
    private String location;

    @NotNull
    @Column(name = "duration")
    private Integer duration;

    @OneToMany(mappedBy = "meeting")
    private List<Participant> participants;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private User user;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EnumMeetingStatus status;

    @OneToOne(mappedBy = "meeting")
    private MeetingMinutes meetingMinutes;

}
