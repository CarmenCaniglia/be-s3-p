package carmen.dao;

import carmen.entities.Book;
import carmen.entities.LibraryItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class LibraryItemDAO {
    private static EntityManager em;
    public LibraryItemDAO (EntityManager em){
        this.em = em;
    }

    public void save(LibraryItem item) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(item);
        transaction.commit();
        System.out.println("Item " + item.getTitle() + " saved");
    }

    public void delete(LibraryItem item) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(item);
        transaction.commit();
        System.out.println("Item " + item.getTitle() + " deleted");

    }

    public static LibraryItem findByIsbn(String isbn) {
        return em.find(LibraryItem.class, isbn);
    }

    public void deleteByIsbn(String isbn) {
        LibraryItem item = findByIsbn(isbn);
        if (item != null) {
            System.out.println(isbn);
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(item);
            transaction.commit();
            System.out.println("Item with isbn " + isbn + " deleted");
        } else {
            System.out.println("Item with isbn " + isbn + " not found");
        }
    }

    public static List<LibraryItem> findByYear(int year){
        TypedQuery<LibraryItem> getByYear = em.createQuery("SELECT i FROM LibraryItem i WHERE i.year = :year",LibraryItem.class);
        getByYear.setParameter("year",year);
        return getByYear.getResultList();
    }

    public static List<Book> findByAuthor(String author){
        TypedQuery<Book> getByAuthor = em.createQuery("SELECT b FROM Book b WHERE b.author = :author", Book.class);
        getByAuthor.setParameter("author", author);
        return getByAuthor.getResultList();
    }

    public static List<LibraryItem> searchByTitle(String title){
        TypedQuery<LibraryItem> findTitle = em.createQuery("SELECT i FROM LibraryItem i WHERE i.title LIKE :title", LibraryItem.class);
        findTitle.setParameter("title", "%" + title + "%");
        return findTitle.getResultList();
    }


}
