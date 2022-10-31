package com.nestdigital.nestEmployee.Dao;

import com.nestdigital.nestEmployee.Model.LeaveModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface LeaveDao extends CrudRepository<LeaveModel,Integer> {
    @Modifying
    @Query(value = "UPDATE `leaves` SET `status`= :status WHERE empid = :id",nativeQuery = true)
    void changeStatusOfLeave(int id,int status);

    @Query(value = "SELECT l.`id`, l.`status`, l.`apply_date`, l.`empid`, l.`leave_date`, l.`type`,l.`description`,e.name FROM `leaves` l JOIN employee e ON l.empid = e.empid",nativeQuery = true)
    List<Map<String,String>> viewAllLeave();



    @Query(value = "SELECT l.`id`, l.`status`, l.`apply_date`, l.`empid`, l.`leave_date`, l.`type`,l.`description`,e.name FROM `leaves` l JOIN employee e ON l.empid = e.empid WHERE l.status=0",nativeQuery = true)
    List<Map<String,String>> viewLeaveByEmpID();

}
