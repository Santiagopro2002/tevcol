package com.utc.tevcol.service;

import com.utc.tevcol.entity.Establecimiento;

import java.util.List;

public interface EstablecimientoService {
    List<Establecimiento> listar();
    Establecimiento buscarPorId(Long id);
    Establecimiento guardar(Establecimiento e);
    void eliminar(Long id);
}