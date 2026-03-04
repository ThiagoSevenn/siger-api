package br.com.siger.siger_api.domain;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private Long id;

    private Date registrationDate;
    private Date modificationDate;
    private Date meetingDate;

    private String title;
    private String description;
    private String status;
    private String location;

    private Integer duration;

    private Boolean concluded;

    private List<Participant> participants;
    
    private MeetingMinutes meetingMinutes;
}
