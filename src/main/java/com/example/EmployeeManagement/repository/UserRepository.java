package com.example.EmployeeManagement.repository;

import com.example.EmployeeManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
