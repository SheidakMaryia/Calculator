package by.sheidak.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Telephone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean isPrimary;
    private String number;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Telephone(int id, boolean isPrimary, String number, User user) {
        this.id = id;
        this.isPrimary = isPrimary;
        this.number = number;
        this.user = user;
    }

    public Telephone(int id, String number, User user) {
        this.id = id;
        this.number = number;
        this.user = user;
    }

    public Telephone(String number, User user) {
        this.number = number;
        this.user = user;
    }

    public Telephone() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telephone telephone = (Telephone) o;
        return id == telephone.id && isPrimary == telephone.isPrimary && Objects.equals(number, telephone.number) && Objects.equals(user, telephone.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isPrimary, number, user);
    }

    @Override
    public String toString() {
        return "Telephone{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", user=" + user +
                '}';
    }
}