package com.utc.tevcol.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalModelAttributes {

    @ModelAttribute("usuarioLogeado")
    public String usuarioLogeado() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) return null;

        String name = auth.getName();
        if (!auth.isAuthenticated() || "anonymousUser".equals(name)) return null;

        return name;
    }
}