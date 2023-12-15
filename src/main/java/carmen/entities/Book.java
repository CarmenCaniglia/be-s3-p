package carmen.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "books")
@DiscriminatorValue("Book")
public class Book extends LibraryItem{
    @Column(name = "author")
    private String author;
    @Column(name = "genre")
    private String genre;


    public Book(){
        super();
    }

    public Book(String isbn, String title, int year, int pages, String author, String genre) {
        super(isbn, title, year, pages);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
