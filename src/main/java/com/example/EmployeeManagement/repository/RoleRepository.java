package com.example.EmployeeManagement.repository;

import com.example.EmployeeManagement.base.BaseRepository;
import com.example.EmployeeManagement.entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends BaseRepository<Role, Long> {

}
