package Entity;

import Entity.Debate;
import Entity.User;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-17T11:11:28", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Comment.class)
public class Comment_ { 

    public static volatile SingularAttribute<Comment, Debate> debateIDFK;
    public static volatile SingularAttribute<Comment, User> userIDFK;
    public static volatile SingularAttribute<Comment, String> commentDate;
    public static volatile SingularAttribute<Comment, String> commentDescription;
    public static volatile SingularAttribute<Comment, Boolean> isActive;
    public static volatile SingularAttribute<Comment, Integer> commentIDPK;

}