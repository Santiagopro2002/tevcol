package com.utc.tevcol.controller;

import com.utc.tevcol.entity.Establecimiento;
import com.utc.tevcol.service.EstablecimientoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/establecimientos")
public class EstablecimientoController {

    private final EstablecimientoService service;

    public EstablecimientoController(EstablecimientoService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("lista", service.listar());
        return "establecimientos/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("establecimiento", new Establecimiento());
        return "establecimientos/form";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("establecimiento", service.buscarPorId(id));
        return "establecimientos/form";
    }

    @PostMapping("/guardar")
public String guardar(@ModelAttribute Establecimiento establecimiento, RedirectAttributes ra) {
    try {
        boolean editando = (establecimiento.getCodigoEst() != null);

        service.guardar(establecimiento);

        ra.addFlashAttribute("success",
                editando ? "Establecimiento actualizado correctamente" : "Establecimiento creado correctamente");

    } catch (RuntimeException e) {
        ra.addFlashAttribute("error", e.getMessage());
    } catch (Exception e) {
        ra.addFlashAttribute("error", "Ocurrió un error al guardar el establecimiento");
    }
    return "redirect:/establecimientos";
}
    
    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, RedirectAttributes ra) {
    try {
        service.eliminar(id);
        ra.addFlashAttribute("success", "Eliminado correctamente");
    } catch (RuntimeException e) {
        ra.addFlashAttribute("error", e.getMessage());
    }
    return "redirect:/establecimientos";
    }
}