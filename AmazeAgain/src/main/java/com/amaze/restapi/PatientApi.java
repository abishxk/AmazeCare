package com.amaze.restapi;

import com.amaze.entity.Patients;
import com.amaze.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientApi {

    @Autowired
    private PatientRepo repo;

    @GetMapping
    public List<Patients> getAllPatients() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Patients getPatientById(@PathVariable int id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public Patients addPatient(@RequestBody Patients patient) {
        return repo.save(patient);
    }

    @PutMapping("/{id}")
    public Patients updatePatient(@PathVariable int id, @RequestBody Patients updatedPatient) {
        Patients existing = repo.findById(id).orElse(null);
        if (existing != null) {
            existing.setFullName(updatedPatient.getFullName());
            existing.setDob(updatedPatient.getDob());
            existing.setGender(updatedPatient.getGender());
            existing.setMobileNumber(updatedPatient.getMobileNumber());
            existing.setEmail(updatedPatient.getEmail());
            existing.setPassword(updatedPatient.getPassword());
            existing.setAddress(updatedPatient.getAddress());
            return repo.save(existing);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Deleted patient with ID: " + id;
        }
        return "Patient not found";
    }
}
