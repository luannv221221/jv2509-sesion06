package com.ra.service;

import com.ra.model.MedicalRecord;
import com.ra.model.enums.MedicalRecordStatus;

import java.util.List;

public interface MedicalRecordService {
    List<MedicalRecord> getTop10();
}
