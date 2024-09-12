package com.example.EmployeeManagement.controller;

import com.example.EmployeeManagement.entity.Manager;
import com.example.EmployeeManagement.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/managers")
public class ManagerController {

    private final ManagerService managerService;

    @Autowired
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping
    public ResponseEntity<List<Manager>> getAllManagers() {
        return new ResponseEntity<>(managerService.getAllManages(), HttpStatus.OK);
    }

    @GetMapping(path = "/{managerId}")
    public ResponseEntity<Optional<Manager>> getManager(@PathVariable Long managerId) {
        Optional<Manager> managerOptional = managerService.getManager(managerId);
        return new ResponseEntity<>(managerOptional, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Manager> postManager(@RequestBody Manager manager) {
        Manager addedNewManager = managerService.addNewManager(manager);
        return new ResponseEntity<>(addedNewManager, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{managerId}")
    public ResponseEntity<Manager> putManager(@PathVariable Long managerId, @RequestBody Manager manager) throws Exception {
        Manager updateManager = managerService.updateManager(managerId, manager);
        return new ResponseEntity<>(updateManager, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{managerId}")
    public void deleteManager(@PathVariable Long managerId) throws Exception {
        managerService.deleteManager(managerId);
    }

}
