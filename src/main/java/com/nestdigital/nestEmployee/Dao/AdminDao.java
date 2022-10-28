package com.nestdigital.nestEmployee.Dao;

import com.nestdigital.nestEmployee.Model.AdminModel;
import com.nestdigital.nestEmployee.Model.SecurityModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface AdminDao extends CrudRepository<AdminModel,Integer> {
    @Query(value = "SELECT * FROM `employee` WHERE `empId`=:id",nativeQuery = true)
    List<AdminModel> search(Integer id);

    @Modifying
    @Query(value = "DELETE FROM `employee` WHERE `empid`=:id",nativeQuery = true)
    void delete(Integer id);


    @Modifying
    @Query(value = "UPDATE `employee` SET `address`= :address,`dob`= :dob,`email`= :email,`empid`= :empid,`jod`= :jod,`name`= :name,`number`= :number,`password`= :password,`username`= :username WHERE `id`= :id",nativeQuery = true)
    void update(String address,String dob,String email,Integer empid,String jod,String name,Integer number,String password,String username,Integer id);

    @Query(value = "SELECT * FROM `employee` WHERE `username`=:username AND `password`=:password",nativeQuery = true)
    void login(String username, String password);


}
