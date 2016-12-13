package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-12T19:20:00")
@StaticMetamodel(Post.class)
public class Post_ { 

    public static volatile SingularAttribute<Post, String> path;
    public static volatile SingularAttribute<Post, String> name;
    public static volatile SingularAttribute<Post, String> description;
    public static volatile SingularAttribute<Post, String> location;
    public static volatile SingularAttribute<Post, Integer> id;
    public static volatile SingularAttribute<Post, Date> time;
    public static volatile SingularAttribute<Post, String> mediatype;
    public static volatile SingularAttribute<Post, Integer> userID;

}