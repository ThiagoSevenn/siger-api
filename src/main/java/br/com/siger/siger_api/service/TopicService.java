package br.com.siger.siger_api.service;

import br.com.siger.siger_api.global.service.GenericBaseService;
import br.com.siger.siger_api.model.Topic;
import br.com.siger.siger_api.repository.TopicRepository;
import org.springframework.stereotype.Service;

@Service
public class TopicService extends GenericBaseService<TopicRepository, Topic, Long> {
}
