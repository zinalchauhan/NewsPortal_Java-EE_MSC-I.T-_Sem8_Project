package Entity;

import Entity.City;
import Entity.Newsimage;
import Entity.Notification;
import Entity.Subcategory;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-17T11:11:28", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(News.class)
public class News_ { 

    public static volatile CollectionAttribute<News, Notification> notificationCollection;
    public static volatile SingularAttribute<News, String> newsSubtitle;
    public static volatile SingularAttribute<News, String> newsDescription;
    public static volatile SingularAttribute<News, Integer> newsIDPK;
    public static volatile SingularAttribute<News, String> newsTitle;
    public static volatile CollectionAttribute<News, Newsimage> newsimageCollection;
    public static volatile SingularAttribute<News, City> cityIDFK;
    public static volatile SingularAttribute<News, Boolean> isActive;
    public static volatile SingularAttribute<News, String> newsStatus;
    public static volatile SingularAttribute<News, String> newsDate;
    public static volatile SingularAttribute<News, Subcategory> subCategoryIDFK;
    public static volatile SingularAttribute<News, String> newsType;

}