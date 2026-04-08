package br.com.siger.siger_api.service;

import br.com.siger.siger_api.global.service.GenericBaseService;
import br.com.siger.siger_api.model.Participant;
import br.com.siger.siger_api.repository.ParticipantRepository;
import org.springframework.stereotype.Service;

@Service
public class ParticipantService extends GenericBaseService<ParticipantRepository, Participant, Long> {
}
