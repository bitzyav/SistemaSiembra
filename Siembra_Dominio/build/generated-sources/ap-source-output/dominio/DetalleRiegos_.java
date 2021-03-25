package dominio;

import dominio.Hectarea;
import dominio.Riego;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-03-24T23:17:19")
@StaticMetamodel(DetalleRiegos.class)
public class DetalleRiegos_ { 

    public static volatile SingularAttribute<DetalleRiegos, Riego> riego;
    public static volatile SingularAttribute<DetalleRiegos, Date> fecha;
    public static volatile SingularAttribute<DetalleRiegos, Hectarea> hectarea;
    public static volatile SingularAttribute<DetalleRiegos, String> nombreTrabajador;
    public static volatile SingularAttribute<DetalleRiegos, Integer> id;

}