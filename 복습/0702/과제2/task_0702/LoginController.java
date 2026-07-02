package com.example.spring.essentials.task_0702;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/task0702/login")
    public String loginForm(HttpSession session) {

        if (session.getAttribute("username") != null) {
            return "redirect:/task0702/dashboard";
        }

        return "task_0702/login";
    }

    @PostMapping("/task0702/login")
    public String login(@RequestParam String username,
                        HttpSession session) {

        session.setAttribute("username", username);

        return "redirect:/task0702/dashboard";
    }

    @GetMapping("/task0702/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/task0702/login";
    }
}