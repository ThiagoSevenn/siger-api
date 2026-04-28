package br.com.siger.siger_api.scheduler;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.siger.siger_api.enums.EnumMeetingStatus;
import br.com.siger.siger_api.model.Meeting;
import br.com.siger.siger_api.repository.MeetingRepository;

@Component
public class MeetingStatusScheduler {
    
    private static final Logger log = LoggerFactory.getLogger(MeetingStatusScheduler.class);
 
    @Autowired
    private MeetingRepository meetingRepository;
 
    @Scheduled(fixedRate = 60000) // roda a cada 1 minuto
    @Transactional
    public void atualizarStatusDasReunioes() {
        LocalDateTime agora = LocalDateTime.now();
 
        List<Meeting> paraIniciar = meetingRepository.findMeetingsToStart(EnumMeetingStatus.NAO_INICIADO, agora);
        for (Meeting meeting : paraIniciar) {
            meeting.setStatus(EnumMeetingStatus.EM_ANDAMENTO);
            meeting.setUpdatedAt(agora);
            log.info("Reunião {} '{}' iniciada automaticamente.", meeting.getId(), meeting.getTitle());
        }
        if (!paraIniciar.isEmpty()) {
            meetingRepository.saveAll(paraIniciar);
        }
 
        List<Meeting> paraFinalizar = meetingRepository.findMeetingsToFinish(EnumMeetingStatus.EM_ANDAMENTO, agora);
        for (Meeting meeting : paraFinalizar) {
            meeting.setStatus(EnumMeetingStatus.CONCLUIDO);
            meeting.setUpdatedAt(agora);
            log.info("Reunião {} '{}' concluída automaticamente.", meeting.getId(), meeting.getTitle());
        }
        if (!paraFinalizar.isEmpty()) {
            meetingRepository.saveAll(paraFinalizar);
        }
    }

}
