package com.nestdigital.nestEmployee.Controller;

import com.nestdigital.nestEmployee.Dao.SecurityDao;
import com.nestdigital.nestEmployee.Model.AdminModel;
import com.nestdigital.nestEmployee.Model.SecurityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class SecurityController {

    @Autowired
    private SecurityDao dao;
    @CrossOrigin("*")
    @PostMapping(path = "/addsecurity",consumes = "application/json",produces = "application/json")
    public String securityadd(@RequestBody SecurityModel security)
    {
        dao.save(security);
        return "{status:success}";
    }

    @CrossOrigin("*")
    @GetMapping("/viewsecurity")
    public List<SecurityModel> viewsecurity()
    {
        return (List<SecurityModel>) dao.findAll();
    }

    @Transactional
    @CrossOrigin("*")
    @PostMapping(path = "/updatesecurity",consumes = "application/json",produces = "application/json")
    public String updateSecurity(@RequestBody SecurityModel security)
    {
dao.update(security.getAddress(),security.getDoj(),security.getName(), security.getNumber(),security.getPassword(),security.getSid(),security.getUsername(),security.getId() );
        return "{status:success}";
    }

    @CrossOrigin("*")
    @PostMapping(path = "/searchsecurity",consumes = "application/json",produces = "application/json")
    public List<SecurityModel> searchsecurity(@RequestBody SecurityModel security)
    {

        return (List<SecurityModel>)  dao.search(security.getSid());
    }


    @Transactional
    @CrossOrigin("*")
    @PostMapping(path = "/deletesecurity",consumes = "application/json",produces = "application/json")
    public String securitydelete(@RequestBody SecurityModel security)
    {
        dao.delete(security.getSid());
        return "{status:success}";
    }


    @CrossOrigin("*")
    @PostMapping(path = "/loginsecurity",consumes = "application/json",produces = "application/json")
    public List<SecurityModel> loginsecurity(@RequestBody SecurityModel security)
    {


        return (List<SecurityModel>) dao.login(security.getUsername(),security.getPassword());
    }

}
