package Entity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-17T11:11:28", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Job.class)
public class Job_ { 

    public static volatile SingularAttribute<Job, String> jobStatus;
    public static volatile SingularAttribute<Job, Integer> jobIDPK;
    public static volatile SingularAttribute<Job, String> jobTitle;
    public static volatile SingularAttribute<Job, String> jobDate;
    public static volatile SingularAttribute<Job, String> jobDescription;
    public static volatile SingularAttribute<Job, Boolean> isActive;

}