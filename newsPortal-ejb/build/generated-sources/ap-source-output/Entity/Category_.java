package Entity;

import Entity.Subcategory;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-17T11:11:28", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile CollectionAttribute<Category, Subcategory> subcategoryCollection;
    public static volatile SingularAttribute<Category, String> categoryIcon;
    public static volatile SingularAttribute<Category, Integer> categoryIDPK;
    public static volatile SingularAttribute<Category, Boolean> isActive;
    public static volatile SingularAttribute<Category, String> categoryName;

}