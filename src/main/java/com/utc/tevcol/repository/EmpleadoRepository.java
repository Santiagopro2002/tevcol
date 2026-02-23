package com.utc.tevcol.repository;

import com.utc.tevcol.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    long countByEstablecimiento_CodigoEst(Long codigoEst);
}