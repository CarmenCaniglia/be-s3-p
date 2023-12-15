package carmen;

import carmen.dao.LibraryItemDAO;
import carmen.dao.LoanDAO;
import carmen.dao.UserDAO;
import carmen.entities.Book;
import carmen.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("be-s3-p");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        LibraryItemDAO lbd = new LibraryItemDAO(em);
        UserDAO ud = new UserDAO(em);
        LoanDAO ld = new LoanDAO(em);

        /*Book harry = new Book("937565", "Harry Potter e il prigioniero di Azkaban",1999,416,"J.K. Rowling","Narrativa");
        lbd.save(harry);*/

        User mario = new User("Mario","Bros", LocalDate.of(1981,8,12));
        ud.save(mario);

    }
}
