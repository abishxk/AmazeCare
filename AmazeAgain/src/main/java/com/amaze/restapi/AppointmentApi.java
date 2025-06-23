package com.amaze.restapi;

import com.amaze.entity.Appointments;
import com.amaze.repository.AppointmentsRepo;
import com.amaze.repository.PatientRepo;
import com.amaze.repository.DoctorsRepo;
import com.amaze.entity.Doctors;
import com.amaze.entity.Patients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentApi {

    @Autowired
    private AppointmentsRepo repo;

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private DoctorsRepo doctorRepo;

    // 1. Get all appointments
    @GetMapping
    public List<Appointments> getAllAppointments() {
        return repo.findAll();
    }

    // 2. Get appointment by ID
    @GetMapping("/{id}")
    public Appointments getAppointmentById(@PathVariable int id) {
        return repo.findById(id).orElse(null);
    }

    // 3. Add a new appointment
    @PostMapping
    public Appointments createAppointment(@RequestBody Appointments appointment) {
        // optional: verify patient and doctor exist
        Patients patient = patientRepo.findById(appointment.getPatient().getId()).orElse(null);
        Doctors doctor = doctorRepo.findById(appointment.getDoctor().getId()).orElse(null);

        if (patient != null && doctor != null) {
            appointment.setPatient(patient);
            appointment.setDoctor(doctor);
            return repo.save(appointment);
        }
        return null;
    }

    // 4. Update appointment
    @PutMapping("/{id}")
    public Appointments updateAppointment(@PathVariable int id, @RequestBody Appointments updated) {
        Appointments existing = repo.findById(id).orElse(null);
        if (existing != null) {
            existing.setAppointmentDate(updated.getAppointmentDate());
            existing.setAppointmentTime(updated.getAppointmentTime());
            existing.setStatus(updated.getStatus());

            Patients patient = patientRepo.findById(updated.getPatient().getId()).orElse(null);
            Doctors doctor = doctorRepo.findById(updated.getDoctor().getId()).orElse(null);

            if (patient != null && doctor != null) {
                existing.setPatient(patient);
                existing.setDoctor(doctor);
                return repo.save(existing);
            }
        }
        return null;
    }

    // 5. Delete appointment
    @DeleteMapping("/{id}")
    public String deleteAppointment(@PathVariable int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Deleted appointment with ID: " + id;
        }
        return "Appointment not found";
    }
}
