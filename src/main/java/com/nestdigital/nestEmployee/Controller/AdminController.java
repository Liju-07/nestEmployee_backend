package com.nestdigital.nestEmployee.Controller;

import com.nestdigital.nestEmployee.Dao.AdminDao;
import com.nestdigital.nestEmployee.Model.AdminModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private AdminDao dao;
@CrossOrigin("*")
    @PostMapping(path = "/addemp",consumes = "application/json",produces = "application/json")
public String employeeadd(@RequestBody AdminModel emp)
{
    dao.save(emp);
    return "{status:success}";
}
@CrossOrigin("*")
    @GetMapping("/viewemp")
public List<AdminModel> viewemp()
{
    return (List<AdminModel>) dao.findAll();
}

    @CrossOrigin("*")
    @PostMapping(path = "/search",consumes = "application/json",produces = "application/json")
    public List<AdminModel> employesearch(@RequestBody AdminModel emp)
    {
       dao.search(emp.getEmpid());
        return (List<AdminModel>) dao.search(emp.getEmpid());
    }

    @Transactional
    @CrossOrigin("*")
    @PostMapping(path = "/delete",consumes = "application/json",produces = "application/json")
    public String employedelete(@RequestBody AdminModel emp)
    {
        dao.delete(emp.getEmpid());
        return "{status:success}";
    }
    @Transactional
    @CrossOrigin("*")
    @PostMapping(path = "/update",consumes = "application/json",produces = "application/json")
    public String employeeupdate(@RequestBody AdminModel emp)
    {
       dao.update(emp.getAddress(),emp.getDob(),emp.getEmail(),emp.getJod(),emp.getName(),emp.getNumber(),emp.getPassword(),emp.getUsername(),emp.getEmpid());
        return "{status:success}";
    }

    @CrossOrigin("*")
    @PostMapping(path = "/loginemployee",consumes = "application/json",produces = "application/json")
    public List<AdminModel> employelogin(@RequestBody AdminModel emp)
    {

       return (List<AdminModel>) dao.login(emp.getUsername(),emp.getPassword());
    }

}
