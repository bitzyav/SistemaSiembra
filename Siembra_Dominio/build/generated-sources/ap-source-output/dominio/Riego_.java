package dominio;

import dominio.DetalleRiegos;
import dominio.EstadoRiego;
import dominio.TipoCultivo;
import dominio.TipoRiego;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-03-24T23:17:19")
@StaticMetamodel(Riego.class)
public class Riego_ { 

    public static volatile SingularAttribute<Riego, TipoCultivo> tipoCultivo;
    public static volatile SingularAttribute<Riego, Integer> capacidadAgua;
    public static volatile SingularAttribute<Riego, Date> fecha;
    public static volatile SingularAttribute<Riego, EstadoRiego> estado;
    public static volatile ListAttribute<Riego, DetalleRiegos> hectareas;
    public static volatile SingularAttribute<Riego, TipoRiego> tipoRiego;
    public static volatile SingularAttribute<Riego, String> observaciones;
    public static volatile SingularAttribute<Riego, Integer> id;
    public static volatile SingularAttribute<Riego, Integer> numHectareas;

}