package com.ra.controller;

import com.ra.model.Doctor;
import com.ra.repository.DoctorRepository;
import com.ra.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/v1/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;


    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Doctor> doctors = doctorService.findAll();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Doctor doctor){
        Doctor doctorNew = doctorService.create(doctor);
        return new ResponseEntity<>(doctorNew,HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Doctor doctor = doctorService.findById(id);
        return new ResponseEntity<>(doctor,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Doctor doctor, @PathVariable Long id){
        Doctor doctorUpdate = doctorService.update(doctor,id);
        return new ResponseEntity<>(doctorUpdate,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> getDelete(@PathVariable Long id){
        doctorService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
