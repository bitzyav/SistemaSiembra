/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Bitzy
 */
@Entity
@Table(name="detalle_riegos")
public class DetalleRiegos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name="id_hectarea")
    private Hectarea hectarea;
    
    @ManyToOne
    @JoinColumn(name="id_riego")
    private Riego riego;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_hora")
    private Date fechaHora;
    
    @Column(name="nombre_empleado", length=100, nullable=false)
    private String nombreEmpleado;

    public DetalleRiegos() {
    }

    public DetalleRiegos(Hectarea hectarea, Riego riego, Date fechaHora, String nombreEmpleado) {
        this.hectarea = hectarea;
        this.riego = riego;
        this.fechaHora = fechaHora;
        this.nombreEmpleado = nombreEmpleado;
    }

    public Integer getId() {
        return id;
    }

    public Hectarea getHectarea() {
        return hectarea;
    }

    public Riego getRiego() {
        return riego;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setHectarea(Hectarea hectarea) {
        this.hectarea = hectarea;
    }

    public void setRiego(Riego riego) {
        this.riego = riego;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
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
        if (!(object instanceof DetalleRiegos)) {
            return false;
        }
        DetalleRiegos other = (DetalleRiegos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.RelHectareaRiego[ id=" + id + " ]";
    }
    
    public Object[] toArray() {
        return new Object[]{
            this.hectarea.getId(),
            this.hectarea.getBloque()
        };
    }
}
