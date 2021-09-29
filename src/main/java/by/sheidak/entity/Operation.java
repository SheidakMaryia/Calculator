package by.sheidak.entity;

import javax.persistence.*;

@Entity
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double num1;
    private double num2;
    private String typeOfOperation;
    private double result;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;


    public Operation(int id, double num1, double num2, String typeOfOperation, double result, User user) {
        this.id = id;
        this.num1 = num1;
        this.num2 = num2;
        this.typeOfOperation = typeOfOperation;
        this.result = result;
        this.user = user;
    }

    public Operation(double num1, double num2, String typeOfOperation, double result, User user) {
        this.num1 = num1;
        this.num2 = num2;
        this.typeOfOperation = typeOfOperation;
        this.result = result;
        this.user = user;
    }

    public Operation(double num1, double num2, String typeOfOperation, double result) {
        this.num1 = num1;
        this.num2 = num2;
        this.typeOfOperation = typeOfOperation;
        this.result = result;
    }

    public Operation(double num1, double num2, String typeOfOperation, User user) {
        this.num1 = num1;
        this.num2 = num2;
        this.typeOfOperation = typeOfOperation;
        this.user = user;
    }

    public Operation() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public String getTypeOfOperation() {
        return typeOfOperation;
    }

    public void setTypeOfOperation(String typeOfOperation) {
        this.typeOfOperation = typeOfOperation;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    

    @Override
    public String toString() {
        return "Operation: " + typeOfOperation + ", with number " + num1 + " and " + num2 + ". Result: " + result +
                ". Operator: " + user.getLogin() + "\n";
    }
}
