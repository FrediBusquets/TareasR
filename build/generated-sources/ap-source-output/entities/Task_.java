package entities;

import entities.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-14T22:08:49")
@StaticMetamodel(Task.class)
public class Task_ { 

    public static volatile SingularAttribute<Task, Integer> idtask;
    public static volatile SingularAttribute<Task, String> title;
    public static volatile SingularAttribute<Task, Boolean> done;
    public static volatile SingularAttribute<Task, User> user;
    public static volatile SingularAttribute<Task, String> content;

}