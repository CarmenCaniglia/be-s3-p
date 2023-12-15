package carmen.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "library_items")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "dtype", discriminatorType = DiscriminatorType.STRING)//dovuta inserire perchè mi dava errore nella costruzione degli elementi (passava un parametro null)

public abstract class LibraryItem { //preferisco inizializzarla come astratta per l'uso della strategia JOINED
    @Id
    private String isbn;
    @Column(name = "title")
    private String title;
    @Column(name = "year_of_publication")
    private int year;
    @Column(name = "pages")
    private int pages;

    @OneToMany(mappedBy = "item", cascade = CascadeType.REMOVE)
    private List<Loan> loans;

    public LibraryItem(){}

    public LibraryItem(String isbn, String title, int year, int pages) {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.pages = pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "LibraryItem{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", pages=" + pages +
                '}';
    }
}
