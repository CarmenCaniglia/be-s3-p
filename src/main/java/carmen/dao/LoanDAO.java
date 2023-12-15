package carmen.dao;

import carmen.entities.Loan;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LoanDAO {
    private EntityManager em;

    public LoanDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Loan loan) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(loan);
        transaction.commit();
        System.out.println("Loan " + loan.getItem().getTitle() + " saved");

    }

    public Loan findById(long id) {
        return em.find(Loan.class, id);
    }

    public void delete(Loan loan) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(loan);
        transaction.commit();
        System.out.println("Loan " + loan.getId() + " deleted");
    }
}
