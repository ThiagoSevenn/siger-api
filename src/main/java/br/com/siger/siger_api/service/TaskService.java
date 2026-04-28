package br.com.siger.siger_api.service;

import org.springframework.stereotype.Service;

import br.com.siger.siger_api.global.service.GenericBaseService;
import br.com.siger.siger_api.model.Task;
import br.com.siger.siger_api.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService extends GenericBaseService<TaskRepository, Task, Long> {
}
