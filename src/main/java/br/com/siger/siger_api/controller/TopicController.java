package br.com.siger.siger_api.controller;

import br.com.siger.siger_api.global.controller.GenericBaseController;
import br.com.siger.siger_api.model.Topic;
import br.com.siger.siger_api.service.TopicService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Tópico")
@RestController
@RequestMapping("/topic")
public class TopicController extends GenericBaseController<TopicService, Topic, Long> {
}
