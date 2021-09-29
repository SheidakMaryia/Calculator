package by.sheidak.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean isPrimary;
    private String city;
    private String street;
    private int numOfHouse;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Address(int id, boolean isPrimary, String city, String street, int numOfHouse, User user) {
        this.id = id;
        this.isPrimary = isPrimary;
        this.city = city;
        this.street = street;
        this.numOfHouse = numOfHouse;
        this.user = user;
    }

    public Address(boolean isPrimary, String city, String street, int numOfHouse, User user) {
        this.isPrimary = isPrimary;
        this.city = city;
        this.street = street;
        this.numOfHouse = numOfHouse;
        this.user = user;
    }

    public Address(int id, String city, String street, int numOfHouse, User user) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.numOfHouse = numOfHouse;
        this.user = user;
    }

    public Address() {
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumOfHouse() {
        return numOfHouse;
    }

    public void setNumOfHouse(int numOfHouse) {
        this.numOfHouse = numOfHouse;
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
        Address address = (Address) o;
        return id == address.id && isPrimary == address.isPrimary && numOfHouse == address.numOfHouse && Objects.equals(city, address.city) && Objects.equals(street, address.street) && Objects.equals(user, address.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isPrimary, city, street, numOfHouse, user);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", numOfHouse=" + numOfHouse +
                ", user=" + user +
                '}';
    }

}
