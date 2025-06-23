package com.amaze.controller;

import com.amaze.entity.Patients;
import com.amaze.repository.PatientRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PatientController {

    @Autowired
    PatientRepo repo;


    @RequestMapping("/register")
    public String register(Patients patients, Model model) {
        repo.save(patients);
        model.addAttribute("p1", patients);
        return "patient_login.jsp";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes) {

        Patients patient = repo.findByEmail(email);

        try {
            if (patient != null && patient.getPassword().equals(password)) {
                session.setAttribute("loggedInPatient", patient);
                return "redirect:/patient_home.jsp";
            } else {
                attributes.addFlashAttribute("error", "Invalid email or password");
                return "redirect:/patient_login.jsp";
            }
        } catch (EntityNotFoundException e) {
            System.err.println(e);
            attributes.addFlashAttribute("error", "Invalid email or password");
            return "redirect:/patient_login.jsp";
        }
    }



}
