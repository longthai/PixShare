package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-12T19:20:00")
@StaticMetamodel(Comment.class)
public class Comment_ { 

    public static volatile SingularAttribute<Comment, Integer> id;
    public static volatile SingularAttribute<Comment, String> text;
    public static volatile SingularAttribute<Comment, Date> time;
    public static volatile SingularAttribute<Comment, Integer> postID;
    public static volatile SingularAttribute<Comment, Integer> userID;

}