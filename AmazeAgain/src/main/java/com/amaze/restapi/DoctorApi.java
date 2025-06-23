package com.amaze.restapi;

import com.amaze.entity.Doctors;
import com.amaze.repository.DoctorsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorApi {

    @Autowired
    private DoctorsRepo repo;

    // 1. Get all doctors
    @GetMapping
    public List<Doctors> getAllDoctors() {
        return repo.findAll();
    }

    // 2. Get doctor by ID
    @GetMapping("/{id}")
    public Doctors getDoctorById(@PathVariable int id) {
        return repo.findById(id).orElse(null);
    }

    // 3. Add a new doctor
    @PostMapping
    public Doctors addDoctor(@RequestBody Doctors doctor) {
        return repo.save(doctor);
    }

    // 4. Update an existing doctor
    @PutMapping("/{id}")
    public Doctors updateDoctor(@PathVariable int id, @RequestBody Doctors updatedDoctor) {
        Doctors existing = repo.findById(id).orElse(null);
        if (existing != null) {
            existing.setFullName(updatedDoctor.getFullName());
            existing.setSpecialty(updatedDoctor.getSpecialty());
            existing.setExperienceYears(updatedDoctor.getExperienceYears());
            existing.setQualification(updatedDoctor.getQualification());
            existing.setDesignation(updatedDoctor.getDesignation());
            existing.setEmail(updatedDoctor.getEmail());
            existing.setPassword(updatedDoctor.getPassword());
            existing.setIsActive(updatedDoctor.getIsActive());
            return repo.save(existing);
        }
        return null;
    }

    // 5. Delete a doctor
    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Deleted doctor with ID: " + id;
        }
        return "Doctor not found";
    }
}
