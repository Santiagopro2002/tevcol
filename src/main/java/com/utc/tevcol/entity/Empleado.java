package com.utc.tevcol.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_emp")
    private Long codigoEmp;

    @Column(name = "identificacion_emp", length = 15)
    private String identificacionEmp;

    @Column(name = "nombre_emp", length = 1000)
    private String nombreEmp;

    @Column(name = "segundo_nombre_emp", nullable = false, length = 100)
    private String segundoNombreEmp;

    @Column(name = "apellido_emp", length = 1000)
    private String apellidoEmp;

    @Column(name = "segundo_apellido_emp", nullable = false, length = 100)
    private String segundoApellidoEmp;

    @Column(name = "email_emp", length = 250)
    private String emailEmp;

    @Column(name = "estado_emp", length = 15)
    private String estadoEmp;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaNacimientoEmp;

    // Para que Thymeleaf no explote, mejor EAGER
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_est")
    private Establecimiento establecimiento;

    // getters/setters
    public Long getCodigoEmp() { return codigoEmp; }
    public void setCodigoEmp(Long codigoEmp) { this.codigoEmp = codigoEmp; }

    public String getIdentificacionEmp() { return identificacionEmp; }
    public void setIdentificacionEmp(String identificacionEmp) { this.identificacionEmp = identificacionEmp; }

    public String getNombreEmp() { return nombreEmp; }
    public void setNombreEmp(String nombreEmp) { this.nombreEmp = nombreEmp; }

    public String getSegundoNombreEmp() { return segundoNombreEmp; }
    public void setSegundoNombreEmp(String segundoNombreEmp) { this.segundoNombreEmp = segundoNombreEmp; }

    public String getApellidoEmp() { return apellidoEmp; }
    public void setApellidoEmp(String apellidoEmp) { this.apellidoEmp = apellidoEmp; }

    public String getSegundoApellidoEmp() { return segundoApellidoEmp; }
    public void setSegundoApellidoEmp(String segundoApellidoEmp) { this.segundoApellidoEmp = segundoApellidoEmp; }

    public String getEmailEmp() { return emailEmp; }
    public void setEmailEmp(String emailEmp) { this.emailEmp = emailEmp; }

    public String getEstadoEmp() { return estadoEmp; }
    public void setEstadoEmp(String estadoEmp) { this.estadoEmp = estadoEmp; }

    public LocalDate getFechaNacimientoEmp() { return fechaNacimientoEmp; }
    public void setFechaNacimientoEmp(LocalDate fechaNacimientoEmp) { this.fechaNacimientoEmp = fechaNacimientoEmp; }

    public Establecimiento getEstablecimiento() { return establecimiento; }
    public void setEstablecimiento(Establecimiento establecimiento) { this.establecimiento = establecimiento; }
}