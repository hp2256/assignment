package com.hp.jdbc.jdbcdemo.service;

import com.hp.jdbc.jdbcdemo.models.Employee;
import com.hp.jdbc.jdbcdemo.repo.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpRepoImpl {
    @Autowired
    private EmpRepo empRepo;


    public List<Employee> getAll() {
        List<Employee> all = new ArrayList<>(empRepo.findAll());
        return all;
    }

    public Employee getEmp(int id) {
        if (empRepo.findById(id).isPresent())
            return empRepo.findById(id).get();
        else
            return null;
    }

    public Employee addEmp(Employee employee) {
        return empRepo.save(employee);
    }

    public Employee updateEmp(Employee employee) {
        return empRepo.save(employee);
    }

    public void deleteEmp(Employee employee) {
        empRepo.delete(employee);
    }
}
