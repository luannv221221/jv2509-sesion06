package com.ra.repository;

import com.ra.model.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord,Long> {

//    @Query("SELECT m FROM MedicalRecord m WHERE m.status = 'PROCESSING' ORDER BY m.createdAt DESC LIMIT 1")
    @NativeQuery("SELECT * FROM medical_record WHERE status = 'PROCESSING' ORDER BY created_at DESC LIMIT 1")
    List<MedicalRecord> getTop10();
}
