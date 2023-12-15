package carmen.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "library_items")

public abstract class LibraryItem {
    @Id
    private String isbn;
    @Column(name = "title")
    private String title;
    @Column(name = "year_of_publication")
    private int year;
    @Column(name = "pages")
    private int pages;

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
