package com.example.EmployeeManagement.implementation;

import com.example.EmployeeManagement.entity.Manager;

import java.util.List;
import java.util.Optional;

public interface ManagerImpl {

    List<Manager> getAllManages();

    Optional<Manager> getManager(long managerId);

    Manager addNewManager(Manager manager);

    Manager updateManager(Long managerId, Manager manager) throws Exception;

    void deleteManager(Long managerId) throws Exception;

}
