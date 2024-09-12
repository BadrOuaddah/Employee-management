package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.entity.Manager;
import com.example.EmployeeManagement.implementation.ManagerImpl;
import com.example.EmployeeManagement.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService implements ManagerImpl {

    private final ManagerRepository managerRepository;

    @Autowired
    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public List<Manager> getAllManages() {
        return managerRepository.findAll();
    }

    public Optional<Manager> getManager(long managerId) {
        return managerRepository.findById(managerId);
    }

    public Manager addNewManager(Manager manager) {
        return managerRepository.save(manager);
    }

    public Manager updateManager(Long managerId, Manager manager) throws Exception {
        managerRepository.findById(managerId).orElseThrow(() -> new Exception("Manager not found with id : " + managerId));
        return managerRepository.save(manager);
    }

    public void deleteManager(Long managerId) throws Exception {
        managerRepository.findById(managerId).orElseThrow(() -> new Exception("Manager not found with id : " + managerId));
        managerRepository.deleteById(managerId);
    }
}
