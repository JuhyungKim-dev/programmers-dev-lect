package com.example.spring.essentials.task_0702;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Controller
public class DashboardController {
    private static final DateTimeFormatter FMT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    @GetMapping("/task0702/dashboard")
    public String dashboard(
            HttpSession session, @CookieValue(value = "lastVisit", required = false)
            String lastVisit, @CookieValue(value = "theme", defaultValue = "light")
            String theme, HttpServletResponse response, Model model) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/task0702/login";
        }
        model.addAttribute("username", username);
        model.addAttribute("theme", theme);
        if (lastVisit != null) {
            long millis = Long.parseLong(lastVisit);
            String readable = Instant.ofEpochMilli(millis).atZone(ZoneId.systemDefault()).format(FMT);
            model.addAttribute("lastVisit", readable);
        }
        Cookie visitCookie = new Cookie("lastVisit", String.valueOf(System.currentTimeMillis()));
        visitCookie.setMaxAge(30 * 24 * 60 * 60);
        visitCookie.setPath("/");
        visitCookie.setHttpOnly(true);
        response.addCookie(visitCookie);
        return "task_0702/dashboard";
    }

    @GetMapping("/task0702/theme")
    public String setTheme(@RequestParam String mode,
                           HttpServletResponse response) {
        String value = "dark".equals(mode) ? "dark" : "light";
        Cookie themeCookie = new Cookie("theme", value);
        themeCookie.setMaxAge(30 * 24 * 60 * 60);
        themeCookie.setPath("/");
        response.addCookie(themeCookie);
        return "redirect:/task0702/dashboard";
    }
}