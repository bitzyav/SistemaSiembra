///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package dominio;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//
///**
// *
// * @author Bitzy
// */
//@Entity
//@Table(name="deshierbes")
//public class Deshierbe implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    
//    @Column(name="estado", length=20, nullable=true)
//    @Enumerated (value=EnumType.STRING)
//    private EstadoProceso estado;
//    
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name="fecha_hora")
//    private Date fechaHora;
//    
////    @OneToMany(mappedBy = "deshierbe", cascade = CascadeType.ALL)
////    private List<DetalleDeshierbe> hectareas;
//
////    public Deshierbe() {
////        this.hectareas = new ArrayList();
////    }
//
////    public Deshierbe(EstadoProceso estado, Date fechaHora, List<DetalleDeshierbe> hectareas) {
////        this.estado = estado;
////        this.fechaHora = fechaHora;
////        this.hectareas = hectareas;
////    }
////
////    public void agregarHectarea(DetalleDeshierbe detalle){
////        this.hectareas.add(detalle);
////    }
//    
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (id != null ? id.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Deshierbe)) {
//            return false;
//        }
//        Deshierbe other = (Deshierbe) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "dominio.Deshierbe[ id=" + id + " ]";
//    }
//    
//}
