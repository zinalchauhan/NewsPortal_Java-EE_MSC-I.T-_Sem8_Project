package Entity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-17T11:11:28", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Ads.class)
public class Ads_ { 

    public static volatile SingularAttribute<Ads, String> adsStatus;
    public static volatile SingularAttribute<Ads, Integer> adsIDPK;
    public static volatile SingularAttribute<Ads, String> adsTitle;
    public static volatile SingularAttribute<Ads, String> adsDescription;
    public static volatile SingularAttribute<Ads, String> adsDate;
    public static volatile SingularAttribute<Ads, Boolean> isActive;
    public static volatile SingularAttribute<Ads, String> adsImage;

}