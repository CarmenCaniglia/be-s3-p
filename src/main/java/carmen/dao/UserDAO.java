package carmen.dao;

import carmen.entities.Loan;
import carmen.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

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

    public List<Loan> searchByCard(int cardNumber){
        TypedQuery<Loan> getItem = em.createQuery("SELECT l FROM Loan l WHERE l.user.cardNumber = :cardNumber", Loan.class);
        getItem.setParameter("cardNumber",cardNumber);
        return getItem.getResultList();
    }
}
