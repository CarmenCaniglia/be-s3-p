package carmen.dao;

import carmen.entities.Loan;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class LoanDAO {
    private static EntityManager em;

    public LoanDAO(EntityManager em) {
        this.em = em;
    }

    public static void save(Loan loan) {
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

    public static List<Loan> searchExpiredLoan(){
        TypedQuery<Loan> missedLoan = em.createQuery("SELECT l FROM Loan l WHERE l.endDate < :today", Loan.class);
        missedLoan.setParameter("today", LocalDate.now());
        return missedLoan.getResultList();
    }
}
