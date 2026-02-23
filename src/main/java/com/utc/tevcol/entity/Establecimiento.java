package com.utc.tevcol.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "establecimiento")
public class Establecimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_est")
    private Long codigoEst;

    @Column(name = "codigo_emp")
    private Long codigoEmp;

    @Column(name = "descripcion_est", length = 500)
    private String descripcionEst;

    @Column(name = "direccion_est", length = 500)
    private String direccionEst;

    @Column(name = "ciudad_est", length = 250)
    private String ciudadEst;

    @Column(name = "estado_est", nullable = false, length = 100)
    private String estadoEst;

    @Column(name = "telefono_est", length = 15)
    private String telefonoEst;

    // getters/setters
    public Long getCodigoEst() { return codigoEst; }
    public void setCodigoEst(Long codigoEst) { this.codigoEst = codigoEst; }

    public Long getCodigoEmp() { return codigoEmp; }
    public void setCodigoEmp(Long codigoEmp) { this.codigoEmp = codigoEmp; }

    public String getDescripcionEst() { return descripcionEst; }
    public void setDescripcionEst(String descripcionEst) { this.descripcionEst = descripcionEst; }

    public String getDireccionEst() { return direccionEst; }
    public void setDireccionEst(String direccionEst) { this.direccionEst = direccionEst; }

    public String getCiudadEst() { return ciudadEst; }
    public void setCiudadEst(String ciudadEst) { this.ciudadEst = ciudadEst; }

    public String getEstadoEst() { return estadoEst; }
    public void setEstadoEst(String estadoEst) { this.estadoEst = estadoEst; }

    public String getTelefonoEst() { return telefonoEst; }
    public void setTelefonoEst(String telefonoEst) { this.telefonoEst = telefonoEst; }
}