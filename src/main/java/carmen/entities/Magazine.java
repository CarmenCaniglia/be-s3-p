package carmen.entities;

import javax.persistence.*;

@Entity
@Table(name = "magazines")
public class Magazine extends LibraryItem{
    @Column(name = "periodicity")
    @Enumerated(EnumType.STRING)
    private Periodicity periodicity;


    public Magazine(String isbn, String title, int year, int pages, Periodicity periodicity) {
        super(isbn, title, year, pages);
        this.periodicity = periodicity;
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "periodicity=" + periodicity +
                '}';
    }
}

