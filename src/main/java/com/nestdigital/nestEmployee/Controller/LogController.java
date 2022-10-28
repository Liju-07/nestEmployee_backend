package com.nestdigital.nestEmployee.Controller;

import com.nestdigital.nestEmployee.Dao.LogDao;
import com.nestdigital.nestEmployee.Model.LogModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class LogController {
    @Autowired
    private LogDao logDao;



    @CrossOrigin(origins = "*")
    @PostMapping("/checkIn")
    public String addLogDetails(@RequestBody LogModel logModel){
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        logModel.setLogin_time((String.valueOf(date.format(now))));
        logDao.save(logModel);
        return "Success";
    }


    @Transactional
    @CrossOrigin(origins = "*")
    @PostMapping("/checkOut")
    public String updateLogDetails(@RequestBody LogModel logModel){
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        logModel.setLogout_time((String.valueOf(date.format(now))));
        logDao.updateLogDetails(logModel.getLogout_time(), logModel.getLogout_sec_id(), logModel.getId());
        return "Success";
    }



    @CrossOrigin(origins = "*")
    @GetMapping("/viewAllLog")
    public List<Map<String,String>> viewAllLog(){
        return (List<Map<String, String>>) logDao.viewAllLogs();
    }


    @CrossOrigin(origins = "*")
    @PostMapping("/viewLogById")
    public List<Map<String,String>> viewLogById(@RequestBody LogModel logModel){
        return (List<Map<String, String>>) logDao.viewLogByEmpId(logModel.getEmp_id());
    }


}
