package com.hp.jdbc.jdbcdemo;

import com.hp.jdbc.jdbcdemo.models.Employee;
import com.hp.jdbc.jdbcdemo.service.EmpRepoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class JdbcDemoApplication implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(JdbcDemoApplication.class);

    @Autowired
    EmpRepoImpl employeedao;

    public static void main(String[] args) {
        SpringApplication.run(JdbcDemoApplication.class, args);

        //    jdbcOps();
    }

    public void jdbcOps() {
        int choice;
        int empid;
        String empname;
        String empaddress;
        boolean end = true;
        while (end) {
            System.out.println("Enter choice 1 to insert, 2 to update, 3 to delete, 4 to show all, 5 to end");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            System.out.println("choice: " + choice);

            switch (choice) {
                case 1:
                    Employee e1 = new Employee();
                    System.out.println("Enter employee id");
                    empid = sc.nextInt();
                    sc.nextLine();
                    e1.setId(empid);
                    System.out.println("Enter employee Name");
                    empname = sc.nextLine();
                    e1.setName(empname);
                    System.out.println("Enter employee address");
                    empaddress = sc.nextLine();
                    e1.setAddress(empaddress);
                    employeedao.addEmp(e1);
                    break;
                case 2:
                    //before update show data and also after update show data

                    employeedao.getAll().stream()
                            .forEach(System.out::println);
                    Employee updateEmp = new Employee();
                    System.out.println("Enter employee id");
                    updateEmp.setId(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Enter employee Name");
                    updateEmp.setName(sc.nextLine());
                    System.out.println("Enter employee address");
                    updateEmp.setAddress(sc.nextLine());
                    employeedao.updateEmp(updateEmp);

                    employeedao.getAll().stream()
                            .forEach(System.out::println);
                    break;
                case 3:
                    //display all data before asking for id for UPDATE and DELETE

                    employeedao.getAll().stream()
                            .forEach(System.out::println);
                    System.out.println("Enter id");
                    int id = sc.nextInt();
                    Employee del = employeedao.getEmp(id);
                    employeedao.deleteEmp(del);

                    employeedao.getAll().stream()
                            .forEach(System.out::println);
                    break;
                case 4:
                    employeedao.getAll().stream()
                                    .forEach(System.out::println);
                   // System.out.println(employeedao.getAll());
                    break;
                case 5:
                    end = false;
                    break;
                default:
                    System.out.println("Enter correct choice: ");
                    break;
            }
        }
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("All users -> {}", employeedao.getAll());
        jdbcOps();

    }


}
