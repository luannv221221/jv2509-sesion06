package com.ra.controller;

import com.ra.model.Patient;
import com.ra.model.dto.PaginationResponse;
import com.ra.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;
    @GetMapping
    public ResponseEntity<?> findAll(@PageableDefault(
            size = 3,sort = "fullName",direction = Sort.Direction.ASC
    )Pageable pageable, @RequestParam(required = false,defaultValue = "",name = "keyword") String keyword){
        PaginationResponse<Patient> patientPaginationResponse = patientService.findAllAndSearch(pageable,keyword);
        return  new ResponseEntity<>(patientPaginationResponse, HttpStatus.OK);
    }
}
