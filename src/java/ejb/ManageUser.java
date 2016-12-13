/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import model.Post;
import model.User;

/**
 *
 * @author Admin
 */
@Stateless
public class ManageUser {

    @PersistenceContext(name = "PixSharePU")
    private EntityManager em;

    //List<User> listUser = getAllUser();
    public User addUser(User user) {
        em.persist(user);
        return user;
    }
    
    public Post addPost(Post post) {
        em.persist(post);
        return post;
    }

    public void update(User user) {
        em.merge(user);
    }

    public User getUser(int Id) {
        return em.find(User.class, Id);
    }

    public List<User> getAllUser() {
        return em.createNamedQuery("User.findAll").getResultList();
    }

    public boolean checkExistUser(User user) {
        try {
            User u = (User) em.createNamedQuery("User.findByUsername").setParameter("username", user.getUsername()).getSingleResult();
            return true;
        } catch (Exception pokemon) {
        }
        return false;
    }

    public User checkLoginStatus(User user) {
        return (User) em.createNamedQuery("User.findByUsernamePassword").setParameter("password", user.getPassword()).setParameter("username", user.getUsername()).getSingleResult();
    }
    
}
