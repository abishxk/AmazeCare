package com.amaze.repository;

import com.amaze.entity.Patients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patients, Integer> {
    Patients findByEmail(String email);

}
