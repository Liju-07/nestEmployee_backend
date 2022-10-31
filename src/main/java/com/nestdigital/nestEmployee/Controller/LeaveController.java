package com.nestdigital.nestEmployee.Controller;

import com.nestdigital.nestEmployee.Dao.LeaveDao;
import com.nestdigital.nestEmployee.Model.LeaveModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
public class LeaveController {

    @Autowired
    private LeaveDao leaveDao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addleave",consumes = "application/json",produces = "application/json")
    public  String addLeave(@RequestBody LeaveModel lm){
        DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String applyDate=String.valueOf((dt.format(now)));
        lm.setApplyDate(applyDate);

        leaveDao.save(lm);
        return "{status:'success'}";
    }





    @Transactional
    @CrossOrigin(origins = "*")
    @PostMapping("/leaveStatus")
    public String changeLeaveStatus(@RequestBody LeaveModel model){
        leaveDao.changeStatusOfLeave(model.getEmpid(), model.getStatus());
        return "Success'";
    }


    @CrossOrigin(origins = "*")
    @GetMapping("/viewAllLeaves")
    public List<Map<String,String>> viewAllLeaves(){
        return (List<Map<String, String>>) leaveDao.viewAllLeave();
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path ="/leavestatus",consumes = "application/json",produces = "application/json" )
    public List<Map<String,String>> leavestatus(@RequestBody LeaveModel lm){
        return (List<Map<String, String>>) leaveDao.status(lm.getEmpid());
    }



    @CrossOrigin(origins = "*")
    @GetMapping("/leaverequests")
    public List<Map<String,String>> viewLeaveById(){
        return (List<Map<String, String>>) leaveDao.viewLeaveByEmpID();
    }


}
