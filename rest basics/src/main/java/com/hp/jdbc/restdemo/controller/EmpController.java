package com.hp.jdbc.restdemo.controller;

import com.hp.jdbc.restdemo.models.Employee;
import com.hp.jdbc.restdemo.service.EmpRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class EmpController {
    @Autowired
    EmpRepoImpl empRepo;

    @GetMapping("/allemp")
    public List<Employee> allEmp() {
        return empRepo.getAll();
    }

    @PostMapping("/addemp")
    public Employee addEmp(@RequestBody Employee employee) {
        return empRepo.addEmp(employee);
    }

    @PutMapping("/updateemp")
    public Employee updateEmp(@RequestBody Employee employee) {
        return empRepo.updateEmp(employee);
    }

    @DeleteMapping("/deleteemp/{id}")
    public void deleteEmp(@PathVariable int id) {
        empRepo.deleteEmpByIds(id);
    }
}
