package com.utc.tevcol.service;

import com.utc.tevcol.entity.Establecimiento;
import com.utc.tevcol.repository.EstablecimientoRepository;
import com.utc.tevcol.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstablecimientoServiceImpl implements EstablecimientoService {

    private final EstablecimientoRepository establecimientoRepository;
    private final EmpleadoRepository empleadoRepository;

    public EstablecimientoServiceImpl(EstablecimientoRepository establecimientoRepository,
                                      EmpleadoRepository empleadoRepository) {
        this.establecimientoRepository = establecimientoRepository;
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public List<Establecimiento> listar() {
        return establecimientoRepository.findAll();
    }

    @Override
    public Establecimiento buscarPorId(Long id) {
        return establecimientoRepository.findById(id).orElse(null);
    }

    @Override
    public Establecimiento guardar(Establecimiento e) {
        return establecimientoRepository.save(e);
    }

    @Override
    public void eliminar(Long id) {
        long usados = empleadoRepository.countByEstablecimiento_CodigoEst(id);
        if (usados > 0) {
            throw new RuntimeException("No se puede eliminar: hay empleados asociados a este establecimiento.");
        }
        establecimientoRepository.deleteById(id);
    }
}