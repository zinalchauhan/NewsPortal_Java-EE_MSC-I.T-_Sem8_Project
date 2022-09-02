package Entity;

import Entity.Comment;
import Entity.Subcategory;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-17T11:11:28", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Debate.class)
public class Debate_ { 

    public static volatile SingularAttribute<Debate, Integer> debateIDPK;
    public static volatile SingularAttribute<Debate, String> debateTitle;
    public static volatile SingularAttribute<Debate, String> debateStartDate;
    public static volatile CollectionAttribute<Debate, Comment> commentCollection;
    public static volatile SingularAttribute<Debate, String> debateStatus;
    public static volatile SingularAttribute<Debate, String> debateEndDate;
    public static volatile SingularAttribute<Debate, Boolean> isActive;
    public static volatile SingularAttribute<Debate, String> debateImage;
    public static volatile SingularAttribute<Debate, Subcategory> subCategoryIDFK;
    public static volatile SingularAttribute<Debate, String> deabteDescription;

}