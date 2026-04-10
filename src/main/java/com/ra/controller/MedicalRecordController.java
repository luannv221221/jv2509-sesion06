package com.ra.controller;

import com.ra.model.MedicalRecord;
import com.ra.service.MedicalRecordService;
import com.ra.service.MedicalRecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedicalRecordController {
    @Autowired
    private MedicalRecordService medicalRecordService;

    @GetMapping("/api/v1/test")
    public ResponseEntity<?> test(){
        List<MedicalRecord> medicalRecords = medicalRecordService.getTop10();
        return new ResponseEntity<>(medicalRecords, HttpStatus.OK);
    }
}
