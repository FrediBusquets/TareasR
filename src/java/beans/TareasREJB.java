/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Task;
import entities.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

/**
 *
 * @author USER
 */
@Stateless
public class TareasREJB {

    @PersistenceUnit
    EntityManagerFactory emf;
      public boolean insertUser(User user) {
        EntityManager em = emf.createEntityManager();
        User exist = em.find(User.class, user.getUsername());
        boolean ok = false;
        if (exist == null) {
            em.persist(user);
            ok = true;
        }
        em.close();
        return ok;
    }
      public User validarUser(String username, String password){
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select u from User u where u.username = :username and u.pass = :password");
        q.setParameter("username", username);
        q.setParameter("password", password);
        if(q.getResultList().size()>0){
            User u = (User) q.getResultList().get(0);
            return u;
        }      
        return null;
    }
   public List<Task> tareasPendientes(User users) throws SQLException{    
     EntityManager em = emf.createEntityManager();
    Query q = em.createQuery("select t from Task t where t.user = :username and t.done is null");
    q.setParameter("username", users);
        return q.getResultList();
   }
   
       public Task selectTask(int current){
        EntityManager em = emf.createEntityManager();
        Task t = em.find(Task.class, current);
        em.close();
        return t;
    }
        public List<Task> selectTaskUser(String username) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select t from Task t where t.user = :owner");
        q.setParameter("owner", new User(username));
        List<Task> t = q.getResultList();
        return t;
    }
      public List<Task> selectTasks(int idFolder) {
        emf.getCache().evictAll();
        EntityManager em = emf.createEntityManager();
        
        User u = em.find(User.class, idFolder);
        return (List<Task>) u.getTaskCollection();
    }
}
