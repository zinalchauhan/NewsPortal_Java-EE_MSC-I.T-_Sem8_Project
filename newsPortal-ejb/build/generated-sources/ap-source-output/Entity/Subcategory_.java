package Entity;

import Entity.Blog;
import Entity.Category;
import Entity.Debate;
import Entity.News;
import Entity.Podcast;
import Entity.Videonews;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-17T11:11:28", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Subcategory.class)
public class Subcategory_ { 

    public static volatile CollectionAttribute<Subcategory, Blog> blogCollection;
    public static volatile CollectionAttribute<Subcategory, Videonews> videonewsCollection;
    public static volatile CollectionAttribute<Subcategory, News> newsCollection;
    public static volatile CollectionAttribute<Subcategory, Podcast> podcastCollection;
    public static volatile CollectionAttribute<Subcategory, Debate> debateCollection;
    public static volatile SingularAttribute<Subcategory, Integer> subCategoryIDPK;
    public static volatile SingularAttribute<Subcategory, Boolean> isActive;
    public static volatile SingularAttribute<Subcategory, Category> categoryIDFK;
    public static volatile SingularAttribute<Subcategory, String> subCategoryName;

}