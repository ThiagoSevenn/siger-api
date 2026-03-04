package br.com.siger.siger_api.domain;

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
@Table(name = "tb_meeting_minutes", schema = "bd_siger")
public class MeetingMinutes {
    @Id
    @GeneratedValue
    private Long id;

    private String objectives;
    private String agenda;  

    
    List<Topic> topics;
}
