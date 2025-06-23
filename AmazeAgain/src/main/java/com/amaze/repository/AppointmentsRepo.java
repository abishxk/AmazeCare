package com.amaze.repository;

import com.amaze.entity.Appointments;
import com.amaze.entity.Doctors;
import com.amaze.entity.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentsRepo extends JpaRepository<Appointments, Integer> {

    // Find all appointments for a specific patient
    List<Appointments> findByPatient(Patients patient);

    // Find all appointments for a specific doctor
    List<Appointments> findByDoctor(Doctors doctor);

    // Optional: Find by patient and doctor
    List<Appointments> findByPatientAndDoctor(Patients patient, Doctors doctor);

    // Optional: Find by status
    //List<Appointments> findByStatus(Appointments.AppointmentStatus status);

    List<Appointments> findByDoctorIdOrderByAppointmentDateAsc(int doctorId);

}
