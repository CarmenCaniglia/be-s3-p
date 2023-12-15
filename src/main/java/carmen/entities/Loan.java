package carmen.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "loans")

public class Loan {
    @Id
    @GeneratedValue
    private long id;
    private User user;
    private LibraryItem item;
    @Column(name = "start_date")
    private LocalDate startDate; //data consegna prevista
    @Column(name = "end_date")
    private LocalDate endDate; //data consegna effettiva

    public Loan (){}

    public Loan(User user, LibraryItem item, LocalDate startDate) {
        this.user = user;
        this.item = item;
        this.startDate = startDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LibraryItem getItem() {
        return item;
    }

    public void setItem(LibraryItem item) {
        this.item = item;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", user=" + user +
                ", item=" + item +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
