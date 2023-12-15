package carmen.dao;

import carmen.entities.LibraryItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LibraryItemDAO {
    private EntityManager em;
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
    public LibraryItem findByIsbn(String id) {
        return em.find(LibraryItem.class, id);
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

}
