package Entity;

import Entity.Subcategory;
import Entity.User;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-17T11:11:28", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Blog.class)
public class Blog_ { 

    public static volatile SingularAttribute<Blog, String> blogDescription;
    public static volatile SingularAttribute<Blog, Integer> blogIDPK;
    public static volatile SingularAttribute<Blog, User> userIDFK;
    public static volatile SingularAttribute<Blog, String> blogImage;
    public static volatile SingularAttribute<Blog, String> blogStatus;
    public static volatile SingularAttribute<Blog, String> blogDate;
    public static volatile SingularAttribute<Blog, Boolean> isActive;
    public static volatile SingularAttribute<Blog, Subcategory> subCategoryIDFK;
    public static volatile SingularAttribute<Blog, String> blogTitle;
    public static volatile SingularAttribute<Blog, String> blogAuthor;

}