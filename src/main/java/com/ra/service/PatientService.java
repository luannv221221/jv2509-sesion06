package com.ra.service;

import com.ra.model.Patient;
import com.ra.model.dto.PaginationResponse;
import org.springframework.data.domain.Pageable;


public interface PatientService {
     PaginationResponse<Patient> findAllAndSearch(Pageable pageable, String patientName);
}
