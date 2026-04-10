package com.ra.service;

import com.ra.model.MedicalRecord;
import com.ra.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {
    @Autowired
    private MedicalRecordRepository medicalRecordRepository;
    @Override
    public List<MedicalRecord> getTop10() {
        return medicalRecordRepository.getTop10();
    }
}
