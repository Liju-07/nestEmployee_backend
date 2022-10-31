package com.nestdigital.nestEmployee.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "leaves")
public class LeaveModel {
    @Id
    @GeneratedValue
    private int id;

    private String type;
    private int empid;
    private String description;
    private String applyDate;
    private String leaveDate;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public String getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LeaveModel() {
    }

    public LeaveModel(int id, String type, int empid, String description, String applyDate, String leaveDate, int status) {
        this.id = id;
        this.type = type;
        this.empid = empid;
        this.description = description;
        this.applyDate = applyDate;
        this.leaveDate = leaveDate;
        this.status = status;
    }
}
