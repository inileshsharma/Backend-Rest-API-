package org.codingwallah.em_project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    
    private Long id;
    private String name;
    private String dept;
    private String email;
    
}
