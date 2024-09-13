package com.example.EmployeeManagement.base;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class BaseController<ENTITY extends BaseEntity, TYPEID extends Object> {

    protected BaseService<ENTITY, TYPEID> service;

    public BaseController(BaseService<ENTITY, TYPEID> service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ENTITY>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<ENTITY>> getOne(@PathVariable TYPEID id) {
        Optional<ENTITY> entity = service.getOneById(id);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ENTITY> post(@RequestBody ENTITY entity) {
        ENTITY added = service.save(entity);
        return new ResponseEntity<>(added, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ENTITY> put(@PathVariable TYPEID id, @RequestBody ENTITY entity) throws Exception {
        ENTITY updated = service.update(id, entity);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable TYPEID id) throws Exception {
        service.deleteById(id);
    }

}
