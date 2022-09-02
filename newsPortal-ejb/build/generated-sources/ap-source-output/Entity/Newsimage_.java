package Entity;

import Entity.News;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-17T11:11:28", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Newsimage.class)
public class Newsimage_ { 

    public static volatile SingularAttribute<Newsimage, String> image;
    public static volatile SingularAttribute<Newsimage, Integer> imageIDPK;
    public static volatile SingularAttribute<Newsimage, Boolean> isActive;
    public static volatile SingularAttribute<Newsimage, News> newsIDFK;

}