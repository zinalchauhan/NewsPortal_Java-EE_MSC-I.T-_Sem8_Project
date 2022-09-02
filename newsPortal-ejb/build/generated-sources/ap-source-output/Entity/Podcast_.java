package Entity;

import Entity.Subcategory;
import Entity.User;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-17T11:11:28", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Podcast.class)
public class Podcast_ { 

    public static volatile SingularAttribute<Podcast, String> podcastDate;
    public static volatile SingularAttribute<Podcast, User> userIDFK;
    public static volatile SingularAttribute<Podcast, String> podcastAudio;
    public static volatile SingularAttribute<Podcast, String> podcastDescription;
    public static volatile SingularAttribute<Podcast, Boolean> isActive;
    public static volatile SingularAttribute<Podcast, Subcategory> subCategoryIDFK;
    public static volatile SingularAttribute<Podcast, Integer> podcastIDPK;
    public static volatile SingularAttribute<Podcast, String> podcastTitle;

}