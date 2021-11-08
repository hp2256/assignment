/*
package com.hp.jdbc.jdbcdemo.service;

import com.hp.jdbc.jdbcdemo.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Employeedao {

    class EmployeeRowMapper implements RowMapper<Employee> {

        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee emp = new Employee();
            emp.setId(rs.getInt("id"));
            emp.setName(rs.getString("name"));
            emp.setAddress(rs.getString("address"));
            return emp;
        }
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Employee> findAll() {
        return jdbcTemplate.query("select * from empdetails", new EmployeeRowMapper());
    }

    public Employee findById(int id) {
        return jdbcTemplate.queryForObject("select * from empdetails where id=?", new BeanPropertyRowMapper<>(Employee.class),
                id);

        */
/*
         * return jdbcTemplate.queryForObject("select * from emp where id=?", new
         * Object[]{id}, new BeanPropertyRowMapper<Employee>(Employee.class));
         *//*

    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from empdetails where id=?", id);
    }

    public int insert(Employee emp) {
        return jdbcTemplate.update("insert into empdetails (id, name, address ) Values(?,?,?) ",
                emp.getId(), emp.getName(), emp.getAddress());
    }

    public int update(Employee emp) {
        return jdbcTemplate.update("update empdetails " + "set name=?, address=? " + " where id=? ",
                emp.getName(), emp.getAddress(), emp.getId());
    }
}
*/
