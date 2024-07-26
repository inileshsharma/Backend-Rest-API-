package org.codingwallah.em_project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmpController {

    @Autowired
    private EmpService callService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return callService.readEmployee();
    }
    
    @PostMapping("/employees")
    public String postCreateEmps(@RequestBody Employee employ) {
        callService.createEmployee(employ);
        return "Saved Success";
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        if (callService.deleteEmployee(id)) {
            return "DELETE SUCCESSFUL";
        } else {
            return "CANNOT DELETE";
        }
    }
    
    @PutMapping("/employees/{id}")
    public String updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employ) {

       return callService.updateEmployee(id, employ);
    }

}
