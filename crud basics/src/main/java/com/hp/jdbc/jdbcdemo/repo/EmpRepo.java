package com.hp.jdbc.jdbcdemo.repo;

import com.hp.jdbc.jdbcdemo.models.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmpRepo extends MongoRepository<Employee,Integer> {
}
