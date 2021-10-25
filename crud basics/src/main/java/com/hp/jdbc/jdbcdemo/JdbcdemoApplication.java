package com.hp.jdbc.jdbcdemo;

import com.hp.jdbc.jdbcdemo.entity.Employee;
import com.hp.jdbc.jdbcdemo.jdbc.Employeedao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class JdbcdemoApplication implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(JdbcdemoApplication.class);
    @Autowired
    Employeedao employeedao;

    public static void main(String[] args) {
        SpringApplication.run(JdbcdemoApplication.class, args);

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
                    empid=sc.nextInt();
                    sc.nextLine();
                    e1.setId(empid);
                    System.out.println("Enter employee Name");
                    empname=sc.nextLine();
                    e1.setName(empname);
                    System.out.println("Enter employee address");
                    empaddress=sc.nextLine();
                    e1.setAddress(empaddress);
                    employeedao.insert(e1);
                    break;
                case 2:
                    Employee updateEmp = new Employee();
                    System.out.println("Enter employee id");
                    updateEmp.setId(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Enter employee Name");
                    updateEmp.setName(sc.nextLine());
                    System.out.println("Enter employee address");
                    updateEmp.setAddress(sc.nextLine());
                    employeedao.update(updateEmp);
                    break;
                case 3:
                    System.out.println("Enter id");
                    employeedao.deleteById(sc.nextInt());
                    break;
                case 4:
                    System.out.println(employeedao.findAll());
                    break;
                case 5:
                    end=false;
                    break;
                default:
                    System.out.println("Enter correct choice: ");
                    break;
            }
        }
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("All users -> {}", employeedao.findAll());
        jdbcOps();

    }


}
