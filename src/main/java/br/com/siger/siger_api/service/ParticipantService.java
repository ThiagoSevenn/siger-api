package br.com.siger.siger_api.service;

import br.com.siger.siger_api.dto.participant.ParticipantRequestDTO;
import br.com.siger.siger_api.enums.EnumMeetingStatus;
import br.com.siger.siger_api.enums.EnumParticipantParticipation;
import br.com.siger.siger_api.enums.EnumParticipantRole;
import br.com.siger.siger_api.enums.EnumUserStatus;
import br.com.siger.siger_api.global.service.GenericBaseService;
import br.com.siger.siger_api.model.Meeting;
import br.com.siger.siger_api.model.Participant;
import br.com.siger.siger_api.model.User;
import br.com.siger.siger_api.repository.MeetingRepository;
import br.com.siger.siger_api.repository.ParticipantRepository;
import br.com.siger.siger_api.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ParticipantService extends GenericBaseService<ParticipantRepository, Participant, Long> {

    @Autowired
    private UserRepository userRepository;
 
    @Autowired
    private MeetingRepository meetingRepository;
 
    @Transactional(rollbackFor = Exception.class)
    public Participant addToMeeting(ParticipantRequestDTO dto) {
        User user = userRepository.findById(dto.userId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com ID: " + dto.userId()));
 
        Meeting meeting = meetingRepository.findById(dto.meetingId())
                .orElseThrow(() -> new IllegalArgumentException("Reunião não encontrada com ID: " + dto.meetingId()));
 
        if (user.getStatus() != EnumUserStatus.ATIVO) {
            throw new IllegalStateException("Não é possível adicionar um usuário inativo como participante.");
        }
        if (meeting.getStatus() == EnumMeetingStatus.CANCELADO) {
            throw new IllegalStateException("Não é possível adicionar participantes a uma reunião cancelada.");
        }
        if (meeting.getStatus() == EnumMeetingStatus.CONCLUIDO) {
            throw new IllegalStateException("Não é possível adicionar participantes a uma reunião já concluída.");
        }
        if (repository.existsByUserIdAndMeetingId(dto.userId(), dto.meetingId())) {
            throw new IllegalStateException("O usuário já é participante desta reunião.");
        }
 
        Participant participant = Participant.builder()
                .user(user)
                .meeting(meeting)
                .role(EnumParticipantRole.valueOf(dto.role()))
                .participation(EnumParticipantParticipation.TALVEZ)
                .build();
 
        return repository.save(participant);
    }
 
    @Transactional(readOnly = true)
    public List<Participant> findByMeeting(Long meetingId) {
        if (!meetingRepository.existsById(meetingId)) {
            throw new IllegalArgumentException("Reunião não encontrada com ID: " + meetingId);
        }
        return repository.findByMeetingId(meetingId);
    }

}
