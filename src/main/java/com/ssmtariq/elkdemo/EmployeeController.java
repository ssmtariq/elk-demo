package com.ssmtariq.elkdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class EmployeeController {
    Logger logger= LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping("/getEmployee/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        List<Employee> employees=getEmployees();
        Employee employee = employees.stream().
                filter(e->e.getId()==id).findAny().orElse(null);
        if(employee!=null){
            logger.info("Employee found : {}",employee);
            return employee;
        }else{
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("Employee Not Found with ID : {}",id);
            }
            return new Employee();
        }
    }

    private List<Employee> getEmployees() {
        return Stream.of(new Employee(1, "Arjun"),
                        new Employee(2, "Azad"),
                        new Employee(3, "Tariq"),
                        new Employee(4, "Spencer"))
                .collect(Collectors.toList());
    }
}
