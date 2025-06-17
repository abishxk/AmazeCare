package com.amaze.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Index_Controller {
    @GetMapping("/")
    public String home() {
        return "index.jsp";
    }

    @GetMapping("/patient_index")
    public String patientHome() {
        return "patient_index.jsp";
    }

    @GetMapping("/doctor_index")
    public String doctorHome() {
        return "doctor_index.jsp";
    }

    @GetMapping("/admin_index")
    public String adminHome() {
        return "admin_index.jsp";
    }
}
