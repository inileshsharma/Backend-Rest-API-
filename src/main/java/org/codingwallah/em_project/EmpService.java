package org.codingwallah.em_project;

import java.util.List;

public interface EmpService {

    String createEmployee(Employee emp);
    List<Employee> readEmployee();
    boolean deleteEmployee(Long id);
    String updateEmployee(Long id ,Employee emp);
}
