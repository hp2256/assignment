package com.hp.jdbc.restdemo.repo;

import com.hp.jdbc.restdemo.models.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmpRepo extends MongoRepository<Employee,Integer> {
int deleteEmpById(int id);
}
