/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Employee;

/**
 *
 * @author Tha-Y
 */
public class EmployeeDTO {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    int id;
    String name;
    String address;

    public EmployeeDTO(Employee e) {
        
        this.id = e.getId();
        this.name = e.getName();
        this.address = e.getAddress();
    }
}
