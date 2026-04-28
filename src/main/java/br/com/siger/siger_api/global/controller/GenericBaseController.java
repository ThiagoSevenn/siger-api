package br.com.siger.siger_api.global.controller;

import br.com.siger.siger_api.global.model.IGenericBaseModel;
import br.com.siger.siger_api.global.service.IGenericBaseService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * @param <S> Classe do serviço da classe a ser controlada.
 * @param <E> Classe da entidade a ser manipulada.
 * @param <T> Classe do tipo de dado do id da classe a ser manipulada.
 */

public class GenericBaseController<S extends IGenericBaseService<E, T>, E extends IGenericBaseModel, T> {

    @Autowired
    protected S service;

    // Criar
    @PostMapping
    @Operation(description = "Inclusão de entidade")
    public ResponseEntity<?> insert(@Valid @RequestBody E entity) {
        E newEntity = service.create(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEntity);
    }

    // Editar
    @PutMapping("/{id:[0-9]+}")
    @Operation(description = "Alteração de entidade")
    public ResponseEntity<?> update(@PathVariable T id, @Valid @RequestBody E entity) {
        E savedEntity = service.update(id, entity);
        return ResponseEntity.ok(savedEntity);
    }

    // Remover
    @DeleteMapping("/{id:[0-9]+}")
    @Operation(description = "Exclusão de entidade")
    public void delete(@PathVariable T id) {
        service.delete(id);
    }

    // Buscar por Id
    @GetMapping("/{id:[0-9]+}")
    @Operation(description = "Buscar por Id")
    public ResponseEntity<?> findById(@PathVariable T id) throws Exception{
        E entity = service.findById(id);
        if(entity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(entity);
    }

    // Listar todas as entidades
    @GetMapping("/findAll")
    @Operation(description = "Listar todas as entidades")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
