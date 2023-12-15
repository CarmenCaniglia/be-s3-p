package carmen.dao;

import carmen.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserDAO {
    private EntityManager em;

    public UserDAO(EntityManager em){
        this.em = em;
    }

    public void save (User user){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(user);
        transaction.commit();
        System.out.println("User " + user.getName() + " saved");
    }

    public User findById(int id) {
        return em.find(User.class, id);
    }

    public void delete (User user){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(user);
        transaction.commit();
        System.out.println("User " + user.getName() + " deleted");
    }
}
