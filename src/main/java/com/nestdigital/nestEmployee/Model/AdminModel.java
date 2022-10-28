package com.nestdigital.nestEmployee.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class AdminModel {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int empid;
    private String address;
    private int number;
    private String email;
    private String username;
    private String password;
    private String dob;
    private String jod;

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

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getJod() {
        return jod;
    }

    public void setJod(String jod) {
        this.jod = jod;
    }

    public AdminModel() {
    }

    public AdminModel(int id, String name, int empid, String address, int number, String email, String username, String password, String dob, String jod) {
        this.id = id;
        this.name = name;
        this.empid = empid;
        this.address = address;
        this.number = number;
        this.email = email;
        this.username = username;
        this.password = password;
        this.dob = dob;
        this.jod = jod;
    }
}
