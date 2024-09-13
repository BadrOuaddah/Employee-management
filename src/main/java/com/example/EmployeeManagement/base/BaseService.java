package com.example.EmployeeManagement.base;

import java.util.List;
import java.util.Optional;

public abstract class BaseService<ENTITY extends BaseEntity, TYPEID extends Object> {

    protected BaseRepository<ENTITY, TYPEID> repository;

    public BaseService(BaseRepository<ENTITY, TYPEID> repository) {
        this.repository = repository;
    }

    List<ENTITY> getAll() {
        return repository.findAll();
    }

    Optional<ENTITY> getOneById(TYPEID id) {
        return repository.findById(id);
    }

    ENTITY save(ENTITY entity) {
        return repository.save(entity);
    }

    ENTITY update(TYPEID id, ENTITY entity) throws Exception {
        repository.findById(id).orElseThrow(() -> new Exception("Not found with id : " + id));
        return repository.save(entity);
    }

    void deleteById(TYPEID id) throws Exception {
        repository.findById(id).orElseThrow(() -> new Exception("Not found with id : " + id));
        repository.deleteById(id);
    }

}
