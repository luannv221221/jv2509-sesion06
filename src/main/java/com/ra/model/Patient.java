package com.ra.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "patient_code",length = 100,unique = true)
    private String patientCode;
    @Column(name = "full_name",length = 150,nullable = false)
    private String fullName;
    @Column(name = "phone",length = 12, unique = true,nullable = false)
    private String phone;
    @Column(name = "address")
    private String address;
}
