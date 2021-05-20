/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Bitzy
 */
@Entity
@Table(name="riegos")
public class Riego implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name="tipo_riego", length=15, nullable=false)
    @Enumerated (value=EnumType.STRING)
    private TipoRiego tipoRiego;
    
    @Column(name="estado", length=20, nullable=true)
    @Enumerated (value=EnumType.STRING)
    private EstadoProceso estado;

    @Column(name="capacidad_agua", length=50, nullable=false)
    private Integer capacidadAgua;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_hora")
    private Date fechaHora;
    
    @Column(name="observaciones", length=200, nullable=true)
    private String observaciones;
    
    @Column(name="empleado", length=200, nullable=false)
    private String nombreEmpleado;
    
    @OneToMany(mappedBy = "riego", cascade = CascadeType.ALL)
    private List<DetalleRiegos> hectareas;

    public Riego() {
        this.hectareas = new ArrayList();
    }

    public Riego(TipoRiego tipoRiego, Integer capacidadAgua, Date fechaHora, String observaciones, EstadoProceso estado, String nombreEmpleado) {
        this.tipoRiego = tipoRiego;
        this.capacidadAgua = capacidadAgua;
        this.fechaHora = fechaHora;
        this.observaciones = observaciones;
        this.estado = estado;
        this.nombreEmpleado = nombreEmpleado;
    }

    public void agregarHectarea(DetalleRiegos relacion){
        this.hectareas.add(relacion);
    }
    
    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    
    
    public Integer getId() {
        return id;
    }

    public Integer getCapacidadAgua() {
        return capacidadAgua;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public List<DetalleRiegos> getHectareas() {
        return hectareas;
    }

    public TipoRiego getTipoRiego() {
        return tipoRiego;
    }

    public EstadoProceso getEstado() {
        return estado;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public void setTipoRiego(TipoRiego tipoRiego) {
        this.tipoRiego = tipoRiego;
    }

    public void setCapacidadAgua(Integer capacidadAgua) {
        this.capacidadAgua = capacidadAgua;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setHectareas(List<DetalleRiegos> hectareas) {
        this.hectareas = hectareas;
    }

    public void setEstado(EstadoProceso estado) {
        this.estado = estado;
    } 

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Riego)) {
            return false;
        }
        Riego other = (Riego) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Riego[ id=" + id + " ]";
    }
    
    public Object[] toArray() {
        return new Object[]{
            this.getId(),
            this.getTipoRiego(),
            this.getCapacidadAgua(),
            this.getFechaHora(),
            this.getObservaciones(),
            this.getNombreEmpleado(),
            this.getEstado()
        };
    }
}
    