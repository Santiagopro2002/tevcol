package com.utc.tevcol.controller;

import com.utc.tevcol.entity.Empleado;
import com.utc.tevcol.service.EmpleadoService;
import com.utc.tevcol.service.EstablecimientoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;
    private final EstablecimientoService establecimientoService;

    public EmpleadoController(EmpleadoService empleadoService, EstablecimientoService establecimientoService) {
        this.empleadoService = empleadoService;
        this.establecimientoService = establecimientoService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("lista", empleadoService.listar());
        return "empleados/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("empleado", new Empleado());
        model.addAttribute("establecimientos", establecimientoService.listar());
        return "empleados/form";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("empleado", empleadoService.buscarPorId(id));
        model.addAttribute("establecimientos", establecimientoService.listar());
        return "empleados/form";
    }

    @PostMapping("/guardar")
public String guardar(@ModelAttribute Empleado empleado,
                      @RequestParam(value = "establecimientoId", required = false) Long establecimientoId,
                      RedirectAttributes ra) {
    try {
        boolean editando = (empleado.getCodigoEmp() != null);

        if (establecimientoId != null && establecimientoId > 0) {
            empleado.setEstablecimiento(establecimientoService.buscarPorId(establecimientoId));
        } else {
            empleado.setEstablecimiento(null);
        }

        empleadoService.guardar(empleado);

        ra.addFlashAttribute("success",
                editando ? "Empleado actualizado correctamente" : "Empleado creado correctamente");

    } catch (RuntimeException e) {
        ra.addFlashAttribute("error", e.getMessage());
    } catch (Exception e) {
        ra.addFlashAttribute("error", "Ocurrió un error al guardar el empleado");
    }

    return "redirect:/empleados";
}
    
    @PostMapping("/eliminar/{id}")
public String eliminar(@PathVariable Long id, RedirectAttributes ra) {
    try {
        empleadoService.eliminar(id);
        ra.addFlashAttribute("success", "Empleado eliminado correctamente");
    } catch (RuntimeException e) {
        ra.addFlashAttribute("error", e.getMessage());
    }
    return "redirect:/empleados";
}
}