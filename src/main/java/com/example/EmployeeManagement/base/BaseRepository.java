package com.example.EmployeeManagement.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<ENTITY extends BaseEntity, TYPEID extends Object> extends JpaRepository<ENTITY, TYPEID>, JpaSpecificationExecutor<ENTITY> {
}
