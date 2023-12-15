package carmen;

import carmen.dao.LibraryItemDAO;
import carmen.dao.LoanDAO;
import carmen.dao.UserDAO;
import carmen.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("be-s3-p");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        LibraryItemDAO lbd = new LibraryItemDAO(em);
        UserDAO ud = new UserDAO(em);
        LoanDAO ld = new LoanDAO(em);

        Book harry = new Book("937565", "Harry Potter and the prisoner of Azkaban",1999,416,"J.K. Rowling","Storytelling");
        Book lotr = new Book("940348329","The Lord of the Rings", 2012, 1178,"J.R.R. Tolkien","Storytelling");
        Magazine focus = new Magazine("54546532","Focus",2023,50, Periodicity.MONTH);
        lbd.save(harry);
        lbd.save(lotr);
        lbd.save(focus);


        User mario = new User("Mario","Bros", LocalDate.of(1981,8,12));
        User luigi = new User("Luigi","Bros", LocalDate.of(1982,3,20));
        ud.save(mario);
        ud.save(luigi);

        Loan loan = new Loan(mario, harry, LocalDate.now());
        LoanDAO.save(loan);

        LibraryItem foundItem = LibraryItemDAO.findByIsbn("937565");
        System.out.println("Item found for ISBN: " + foundItem);

        List<LibraryItem> itemsByYear = LibraryItemDAO.findByYear(1999);
        System.out.println("Found by year of publication : " + itemsByYear);

        List<Book> booksByAuthor = LibraryItemDAO.findByAuthor("J.K. Rowling");
        System.out.println("Found by author: " + booksByAuthor);

        List<LibraryItem> itemsByTitle = LibraryItemDAO.searchByTitle("The Lord of the Rings");
        System.out.println("Found by title: " + itemsByTitle);

        List<Loan> expiredLoans = LoanDAO.searchExpiredLoan();
        System.out.println("Overdue loans: " + expiredLoans);


        em.close();
        emf.close();
    }
}
