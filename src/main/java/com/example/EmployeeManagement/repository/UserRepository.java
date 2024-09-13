package com.example.EmployeeManagement.repository;

import com.example.EmployeeManagement.base.BaseRepository;
import com.example.EmployeeManagement.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {

}
