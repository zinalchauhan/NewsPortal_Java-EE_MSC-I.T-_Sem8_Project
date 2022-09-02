package Entity;

import Entity.City;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-17T11:11:28", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> userAddress;
    public static volatile SingularAttribute<User, String> userPassword;
    public static volatile SingularAttribute<User, Integer> userStatus;
    public static volatile SingularAttribute<User, String> userImage;
    public static volatile SingularAttribute<User, String> userMobile;
    public static volatile SingularAttribute<User, Integer> userIDPK;
    public static volatile SingularAttribute<User, String> userGender;
    public static volatile SingularAttribute<User, String> userEmail;
    public static volatile SingularAttribute<User, City> cityIDFK;
    public static volatile SingularAttribute<User, String> userType;
    public static volatile SingularAttribute<User, String> userName;
    public static volatile SingularAttribute<User, Boolean> isActive;

}