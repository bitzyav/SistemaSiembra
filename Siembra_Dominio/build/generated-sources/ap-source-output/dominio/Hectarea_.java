package dominio;

import dominio.DetalleRiegos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-03-25T19:07:32")
@StaticMetamodel(Hectarea.class)
public class Hectarea_ { 

    public static volatile ListAttribute<Hectarea, DetalleRiegos> riegos;
    public static volatile SingularAttribute<Hectarea, Integer> id;
    public static volatile SingularAttribute<Hectarea, String> bloque;
    public static volatile SingularAttribute<Hectarea, String> ubicacionPredio;

}