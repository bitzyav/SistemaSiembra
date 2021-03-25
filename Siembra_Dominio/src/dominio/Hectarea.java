/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Bitzy
 */

@Entity
@Table(name="hectareas")
public class Hectarea implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name="ubicacion_predio", length=50, nullable=false) 
    private String ubicacionPredio;
    
    @Column(name="bloque", length=100, nullable=false) 
    private String bloque;
    
    @OneToMany(mappedBy = "hectarea", cascade = CascadeType.ALL)
    private List<DetalleRiegos> riegos;
    
    @OneToMany(mappedBy = "hectarea", cascade = CascadeType.ALL)
    private List<DetalleDeshierbe> deshierbes;

    public Hectarea() {
        this.riegos = new ArrayList();
        this.deshierbes = new ArrayList();
    }
    
    public void agregarRiego(DetalleRiegos detalle){
        this.riegos.add(detalle);
    }
    
    public void agregarDeshierbe(DetalleDeshierbe detalle){
        this.deshierbes.add(detalle);
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBloque() {
        return bloque;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    public String getUbicacionPredio() {
        return ubicacionPredio;
    }

    public List<DetalleRiegos> getRiegos() {
        return riegos;
    }

    public void setUbicacionPredio(String ubicacionPredio) {
        this.ubicacionPredio = ubicacionPredio;
    }

    public void setRiegos(List<DetalleRiegos> riegos) {
        this.riegos = riegos;
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
        if (!(object instanceof Hectarea)) {
            return false;
        }
        Hectarea other = (Hectarea) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Hectarea[ id=" + id + " ]";
    }
    
}
