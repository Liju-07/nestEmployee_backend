package com.nestdigital.nestEmployee.Dao;

import com.nestdigital.nestEmployee.Model.SecurityModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SecurityDao  extends CrudRepository<SecurityModel,Integer> {

@Modifying
    @Query(value = "UPDATE `security` SET `address`=:address,`doj`=:doj,`name`=:name,`number`=:number,`password`=:password,`sid`=:sid,`username`=:username WHERE `id`=:id",nativeQuery = true)
    void update(String address,String doj,String name,Integer number,String password,Integer sid,String username,Integer id);

    @Query(value = "SELECT * FROM `security` WHERE `sid`=:sid",nativeQuery = true)
    List<SecurityModel>search(Integer sid);

    @Modifying
    @Query(value = "DELETE FROM `security` WHERE `sid`=:sid",nativeQuery = true)
    void delete(Integer sid);

    @Query(value = "SELECT * FROM `security` WHERE `username`=:username AND `password`=:password",nativeQuery = true)
    List<SecurityModel> login(String username,String password);



}

