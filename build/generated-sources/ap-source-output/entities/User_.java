package entities;

import entities.Task;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-14T22:08:49")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile CollectionAttribute<User, Task> taskCollection;
    public static volatile SingularAttribute<User, String> pass;
    public static volatile SingularAttribute<User, String> name;
    public static volatile SingularAttribute<User, Integer> age;
    public static volatile SingularAttribute<User, String> username;

}