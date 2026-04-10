package com.ra.service;

import com.ra.model.Patient;
import com.ra.model.dto.PaginationResponse;
import com.ra.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService{
    @Autowired
    private PatientRepository patientRepository;
    @Override
    public PaginationResponse<Patient> findAllAndSearch(Pageable pageable, String patientName) {
        Page<Patient> page = patientRepository.findByFullNameContainingIgnoreCase(patientName,pageable);
        // convert ENTITY => DTO
        return PaginationResponse.<Patient>builder()
                .data(page.getContent())
                .totalPage(page.getTotalPages())
                .totalElement((int) page.getTotalElements())
                .currentPage(page.getNumber())
                .build();
    }
}
