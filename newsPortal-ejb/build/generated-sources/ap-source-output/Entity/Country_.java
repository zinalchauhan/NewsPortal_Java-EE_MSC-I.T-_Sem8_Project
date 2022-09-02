package Entity;

import Entity.State;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-17T11:11:28", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Country.class)
public class Country_ { 

    public static volatile CollectionAttribute<Country, State> stateCollection;
    public static volatile SingularAttribute<Country, Integer> countryIDPK;
    public static volatile SingularAttribute<Country, String> countryName;
    public static volatile SingularAttribute<Country, Boolean> isActive;

}