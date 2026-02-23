package com.utc.tevcol.service;

import com.utc.tevcol.entity.Empleado;
import java.util.List;

public interface EmpleadoService {
    List<Empleado> listar();
    Empleado buscarPorId(Long id);
    Empleado guardar(Empleado e);
    void eliminar(Long id);
}