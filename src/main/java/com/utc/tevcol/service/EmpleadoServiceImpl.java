package com.utc.tevcol.service;

import com.utc.tevcol.entity.Empleado;
import com.utc.tevcol.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository repo;

    public EmpleadoServiceImpl(EmpleadoRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Empleado> listar() {
        return repo.findAll();
    }

    @Override
    public Empleado buscarPorId(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
    }

    @Override
    public Empleado guardar(Empleado e) {
        return repo.save(e);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}