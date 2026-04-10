package com.ra.service;

import com.ra.model.Doctor;
import com.ra.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    private DoctorRepository doctorRepository;
    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor findById(Long id) {
        return doctorRepository.findById(id).orElseThrow(()->new RuntimeException("Khong ton bac si"));
    }

    @Override
    public Doctor create(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor update(Doctor doctor, Long id) {
        if(doctorRepository.findById(id).isEmpty()){
            throw new RuntimeException("Khong tim duoc bac si can sua");
        }
        doctor.setId(id);
        return doctorRepository.save(doctor);
    }

    @Override
    public void delete(Long id) {
        doctorRepository.deleteById(id);
    }
}
