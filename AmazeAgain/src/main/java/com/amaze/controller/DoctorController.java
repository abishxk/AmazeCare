package com.amaze.controller;

import com.amaze.entity.Doctors;
import com.amaze.repository.DoctorsRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DoctorController {

    @Autowired
    DoctorsRepo repo;

    @GetMapping("/doctor_index")
    public String showDoctorSignUp() {
        return "doctor_index.jsp";
    }

    @PostMapping("/doctor_register")
    public String registerDoctor(@ModelAttribute Doctors doctor, RedirectAttributes attributes) {
        try {
            repo.save(doctor);
            return "redirect:/doctor_login";
        } catch (Exception e) {
            attributes.addFlashAttribute("error", "Email already exists or invalid data.");
            return "redirect:/doctor_index";
        }
    }

    @GetMapping("/doctor_login")
    public String showDoctorLoginPage() {
        return "doctor_login.jsp";
    }

    @PostMapping("/doctor_login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes) {

        try {
            Doctors doctor = repo.findByEmail(email);
            if (doctor != null && doctor.getPassword().equals(password)) {
                session.setAttribute("loggedInDoctor", doctor);
                return "redirect:/doctor_home.jsp";
            } else {
                attributes.addFlashAttribute("error", "Invalid email or password");
                return "redirect:/doctor_login.jsp";
            }
        } catch (EntityNotFoundException e) {
            attributes.addFlashAttribute("error", "Login error occurred");
            return "redirect:/doctor_login.jsp";
        }
    }

    @RequestMapping("/doctor_logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index.jsp";
    }
}
