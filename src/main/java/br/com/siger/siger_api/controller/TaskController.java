package br.com.siger.siger_api.controller;

import br.com.siger.siger_api.global.controller.GenericBaseController;
import br.com.siger.siger_api.model.Task;
import br.com.siger.siger_api.service.TaskService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Tarefas")
@RestController
@RequestMapping("/task")
public class TaskController extends GenericBaseController<TaskService ,Task, Long> {
}
