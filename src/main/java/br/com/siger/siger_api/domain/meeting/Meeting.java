package br.com.siger.siger_api.domain.meeting;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import br.com.siger.siger_api.domain.partcipant.Participant;
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
@Table(name = "tb_meeting", schema = "bd_siger")
public class Meeting {
    @Id
    @GeneratedValue
    private UUID id;

    private Date registrationDate;
    private Date modificationDate;
    private Date meetingDate;

    private String title;
    private String description;
    private String status;
    private String location;

    private Integer duration;

    private Boolean concluded;

    @OneToMany(mappedBy = "meeting")
    private List<Participant> participants;
}
