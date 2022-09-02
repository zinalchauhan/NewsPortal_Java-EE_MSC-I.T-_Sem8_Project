package Entity;

import Entity.News;
import Entity.User;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-17T11:11:28", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Notification.class)
public class Notification_ { 

    public static volatile SingularAttribute<Notification, String> notificationStatus;
    public static volatile SingularAttribute<Notification, User> userIDFK;
    public static volatile SingularAttribute<Notification, Integer> notificationIDPK;
    public static volatile SingularAttribute<Notification, Boolean> isActive;
    public static volatile SingularAttribute<Notification, News> newsIDFK;

}