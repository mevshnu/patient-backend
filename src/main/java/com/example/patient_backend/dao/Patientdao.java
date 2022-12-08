package com.example.patient_backend.dao;

import com.example.patient_backend.model.Patientmodel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Patientdao extends CrudRepository<Patientmodel,Integer>
{
    @Query(value ="SELECT `id`, `address`, `date`, `doctor`, `ids`, `image`, `number`, `username` FROM `patient` WHERE `ids`=:ids ",nativeQuery = true)
    List<Patientmodel> SearchPatient(@Param("ids")Integer ids);

    @Modifying
    @Transactional
    @Query(value="DELETE FROM `patient` WHERE `id`=:id",nativeQuery = true)
    void Deletepatient(@Param("id") Integer id);
}
