package com.amaze.repository;

import com.amaze.entity.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorsRepo extends JpaRepository<Doctors, Integer> {
    Doctors findByEmail(String email);
}
