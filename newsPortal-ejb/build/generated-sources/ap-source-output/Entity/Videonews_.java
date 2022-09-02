package Entity;

import Entity.City;
import Entity.Subcategory;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-17T11:11:28", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Videonews.class)
public class Videonews_ { 

    public static volatile SingularAttribute<Videonews, Integer> videoNewsIDPK;
    public static volatile SingularAttribute<Videonews, String> videoNewsDescription;
    public static volatile SingularAttribute<Videonews, String> videoNewsStatus;
    public static volatile SingularAttribute<Videonews, String> videoNewsDate;
    public static volatile SingularAttribute<Videonews, String> video;
    public static volatile SingularAttribute<Videonews, City> cityIDFK;
    public static volatile SingularAttribute<Videonews, Boolean> isActive;
    public static volatile SingularAttribute<Videonews, Subcategory> subCategoryIDFK;
    public static volatile SingularAttribute<Videonews, String> videoNewsTitle;

}