package com.example.patient_backend.controller;


import com.example.patient_backend.dao.Patientdao;
import com.example.patient_backend.model.Patientmodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Patientcontroller {
    @Autowired
    private Patientdao dao;
    @CrossOrigin(origins ="*")
    @GetMapping("/viewall")
    public List<Patientmodel> Viewall()
    {
        return (List<Patientmodel>) dao.findAll();
    }
    @CrossOrigin(origins ="*")
    @PostMapping(path="/add",consumes = "application/json",produces = "application/json")
    public Map<String,String> Add(@RequestBody Patientmodel p)
    {
        System.out.println(p.getIds());
        System.out.println(p.getUsername().toString());
        System.out.println(p.getAddress().toString());
        System.out.println(p.getNumber().toString());
        System.out.println(p.getDate().toString());
        System.out.println(p.getImage().toString());
        System.out.println(p.getDoctor().toString());
        dao.save(p);

        HashMap<String,String> map = new HashMap<>();
        map.put("status","success");
        return map;

    }
    @CrossOrigin(origins="*")
    @PostMapping(path="/search",consumes = "application/json",produces = "application/json")
    public List<Patientmodel> Search(@RequestBody Patientmodel pi)
    {
        String pats = String.valueOf(pi.getIds());
        System.out.println(pats);
        dao.SearchPatient(pi.getIds());
        return (List<Patientmodel>) dao.SearchPatient(pi.getIds());

    }
    @CrossOrigin(origins="*")
    @PostMapping(path="/delete",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> Delete(@RequestBody Patientmodel ps)
    {
        String patd = String.valueOf(ps.getId());
        System.out.println(patd);
        dao.Deletepatient(ps.getId());
        HashMap<String,String> map= new HashMap<>();
        map.put("status","success");
        return map;
    }
}
