package com.utc.tevcol.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardPowerBiController {

    // Opción recomendada: leer la URL desde application.properties
    @Value("${powerbi.embed.url:}")
    private String powerBiEmbedUrl;

    @GetMapping("/dashboard-powerbi")
    public String dashboardPowerBi(Model model) {
        model.addAttribute("powerBiEmbedUrl", powerBiEmbedUrl);
        return "dashboard/powerbi"; // templates/dashboard/powerbi.html
    }
}