package br.com.siger.siger_api.service;

import br.com.siger.siger_api.global.service.GenericBaseService;
import br.com.siger.siger_api.model.Meeting;
import br.com.siger.siger_api.repository.MeetingRepository;
import org.springframework.stereotype.Service;

@Service
public class MeetingService extends GenericBaseService<MeetingRepository, Meeting, Long> {
}
