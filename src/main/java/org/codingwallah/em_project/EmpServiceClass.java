package org.codingwallah.em_project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceClass implements EmpService {
    
    @Autowired
    private EmpRepo employRepo;

    @Override
    public String createEmployee(Employee emp) {
        EmpEntity empEntity = new EmpEntity();
        BeanUtils.copyProperties(emp, empEntity);
        employRepo.save(empEntity);
        
        return "success";
    }

    @Override
    public List<Employee> readEmployee() {
        List<EmpEntity> employArr = employRepo.findAll();

        List<Employee> employees = new ArrayList<>();

        for (EmpEntity em : employArr) {
            Employee objEmp = new Employee();
            BeanUtils.copyProperties(em, objEmp);
            employees.add(objEmp);
        }

        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        if (employRepo.existsById(id)) {
            employRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String updateEmployee(Long id, Employee emp) {
        if (employRepo.existsById(id)) {
            EmpEntity empEntity = employRepo.findById(id).orElse(null);
            if (empEntity != null) {
                BeanUtils.copyProperties(emp, empEntity, "id");
                employRepo.save(empEntity);
                return "UPDATE SUCCESSFUL";
            }
        }
        return "EMPLOYEE NOT FOUND";
    }
    

}
