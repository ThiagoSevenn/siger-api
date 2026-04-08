package br.com.siger.siger_api.service;

import br.com.siger.siger_api.global.service.GenericBaseService;
import br.com.siger.siger_api.model.MeetingMinutes;
import br.com.siger.siger_api.repository.MeetingMinutesRepository;
import org.springframework.stereotype.Service;

@Service
public class MeetingMinutesService extends GenericBaseService<MeetingMinutesRepository, MeetingMinutes, Long> {
}
