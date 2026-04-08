package br.com.siger.siger_api.service;

import br.com.siger.siger_api.model.Log;
import br.com.siger.siger_api.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    @Autowired
    private LogRepository repository;

    public Log logInsert(String operation) {
        Log newLog = repository.save(new Log(operation,"nome"));
        return newLog;
    }
    
}
