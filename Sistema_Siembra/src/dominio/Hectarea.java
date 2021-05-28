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
@Table(name = "hectareas")
public class Hectarea implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "bloque", length = 100, nullable = false)
    private String bloque;
    
    @Column(name = "lote", length = 100, nullable = false)
    private String lote;

    @Column(name = "tipo_hectarea", length = 100, nullable = false)
    private String tipoHectarea;
    
    @Column(name = "coordenadas", length = 100, nullable = false)
    private String coordenadas;
    
    @Column(name = "arrendatario", length = 150, nullable = false)
    private String arrendatario;

    @OneToMany(mappedBy = "hectarea", cascade = CascadeType.ALL)
    private List<DetalleRiegos> riegos;

//    @OneToMany(mappedBy = "hectarea", cascade = CascadeType.ALL)
//    private List<DetalleDeshierbe> deshierbes;

    public Hectarea(String bloque, String lote, String tipoHectarea, String coordenadas, String arrendatario) {
        this.bloque = bloque;
        this.lote = lote;
        this.tipoHectarea = tipoHectarea;
        this.coordenadas = coordenadas;
        this.arrendatario = arrendatario;
    }

    public Hectarea() {
        this.riegos = new ArrayList();
//        this.deshierbes = new ArrayList();
    }

    public void agregarRiego(DetalleRiegos detalle) {
        this.riegos.add(detalle);
    }

//    public void agregarDeshierbe(DetalleDeshierbe detalle){
//        this.deshierbes.add(detalle);
//    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getArrendatario() {
        return arrendatario;
    }

    public void setArrendatario(String arrendatario) {
        this.arrendatario = arrendatario;
    }

    public String getTipoHectarea() {
        return tipoHectarea;
    }

    public void setTipoHectarea(String tipoHectarea) {
        this.tipoHectarea = tipoHectarea;
    }

    public String getBloque() {
        return bloque;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    public List<DetalleRiegos> getRiegos() {
        return riegos;
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

    //acomo en tabla, en orden.
    public Object[] toArray() {
        return new Object[]{
            this.getId(),
            this.getCoordenadas(),
            this.getLote(),
            this.getBloque(),
            this.getTipoHectarea(),
            this.getArrendatario()

        };
    }
    
    public Object[] toArrayFrmRiego() {
        return new Object[]{
            this.getId(),
            this.getCoordenadas(),
            this.getBloque(),
            this.getTipoHectarea(),
        };
    }
}
