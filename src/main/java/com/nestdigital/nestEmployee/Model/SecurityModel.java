package com.nestdigital.nestEmployee.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "security")
public class SecurityModel {
    @Id
    @GeneratedValue
    private int id;
    private int sid;
    private String name;
    private String doj;
    private int number;
    private String password;
    private String username;
    private String address;

    public SecurityModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public SecurityModel(int id, int sid, String name, String doj, int number, String password, String username, String address) {
        this.id = id;
        this.sid = sid;
        this.name = name;
        this.doj = doj;
        this.number = number;
        this.password = password;
        this.username = username;
        this.address = address;
    }
}
