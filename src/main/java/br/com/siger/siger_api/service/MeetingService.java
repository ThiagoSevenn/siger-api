package br.com.siger.siger_api.service;
 
import br.com.siger.siger_api.dto.meeting.MeetingRequestDTO;
import br.com.siger.siger_api.dto.meeting.MeetingUpdateDTO;
import br.com.siger.siger_api.enums.EnumMeetingStatus;
import br.com.siger.siger_api.global.service.GenericBaseService;
import br.com.siger.siger_api.model.Meeting;
import br.com.siger.siger_api.model.User;
import br.com.siger.siger_api.repository.MeetingRepository;
import br.com.siger.siger_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import java.time.LocalDateTime;
 
@Service
public class MeetingService extends GenericBaseService<MeetingRepository, Meeting, Long> {
 
    @Autowired
    private UserRepository userRepository;
 
    @Transactional(rollbackFor = Exception.class)
    public Meeting createFromDTO(MeetingRequestDTO dto) {
        User organizer = userRepository.findById(dto.userId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário organizador não encontrado com ID: " + dto.userId()));
 
        Meeting meeting = Meeting.builder()
                .title(dto.title())
                .description(dto.description())
                .location(dto.location())
                .meetingDate(dto.meetingDate())
                .duration(dto.duration())
                .status(EnumMeetingStatus.NAO_INICIADO)
                .user(organizer)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
 
        return repository.save(meeting);
    }

    @Transactional(rollbackFor = Exception.class)
    public Meeting updateFromDTO(Long id, MeetingUpdateDTO dto) {
        Meeting meeting = findById(id);
        if (meeting == null) {
            throw new IllegalArgumentException("Reunião não encontrada com ID: " + id);
        }
 
        EnumMeetingStatus novoStatus = EnumMeetingStatus.valueOf(dto.status());
 
        meeting.setTitle(dto.title());
        meeting.setDescription(dto.description());
        meeting.setLocation(dto.location());
        meeting.setMeetingDate(dto.meetingDate());
        meeting.setDuration(dto.duration());
        meeting.setStatus(novoStatus);
        meeting.setUpdatedAt(LocalDateTime.now());
 
        return repository.save(meeting);
    }

    @Transactional(rollbackFor = Exception.class)
    public Meeting cancel(Long id) {
        Meeting meeting = findById(id);
        if (meeting == null) {
            throw new IllegalArgumentException("Reunião não encontrada com ID: " + id);
        }
        if (meeting.getStatus() == EnumMeetingStatus.CANCELADO) {
            throw new IllegalStateException("A reunião já está cancelada.");
        }
        if (meeting.getStatus() == EnumMeetingStatus.CONCLUIDO) {
            throw new IllegalStateException("Não é possível cancelar uma reunião já concluída.");
        }
 
        meeting.setStatus(EnumMeetingStatus.CANCELADO);
        meeting.setUpdatedAt(LocalDateTime.now());
 
        return repository.save(meeting);
    }

}
 