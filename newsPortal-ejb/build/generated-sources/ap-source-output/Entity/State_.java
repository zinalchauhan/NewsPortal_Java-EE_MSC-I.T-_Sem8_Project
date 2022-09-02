package Entity;

import Entity.City;
import Entity.Country;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-17T11:11:28", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(State.class)
public class State_ { 

    public static volatile SingularAttribute<State, Integer> stateIDPK;
    public static volatile SingularAttribute<State, Country> countryIDFK;
    public static volatile SingularAttribute<State, String> stateName;
    public static volatile CollectionAttribute<State, City> cityCollection;
    public static volatile SingularAttribute<State, Boolean> isActive;

}