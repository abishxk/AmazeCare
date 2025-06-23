package com.amaze.repository;

import com.amaze.entity.MedicalRecords;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRecordRepo extends JpaRepository<MedicalRecords, Integer> {

    // Find by appointment ID (optional but useful)
    MedicalRecords findByAppointmentId(int appointmentId);
}
