package dominio;

import dominio.Hectarea;
import dominio.Riego;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-20T02:19:02")
@StaticMetamodel(DetalleRiegos.class)
public class DetalleRiegos_ { 

    public static volatile SingularAttribute<DetalleRiegos, Riego> riego;
    public static volatile SingularAttribute<DetalleRiegos, Hectarea> hectarea;
    public static volatile SingularAttribute<DetalleRiegos, Date> fechaHora;
    public static volatile SingularAttribute<DetalleRiegos, Integer> id;
    public static volatile SingularAttribute<DetalleRiegos, String> nombreEmpleado;

}