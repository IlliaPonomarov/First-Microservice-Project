package com.micro.account.models;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;
    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    public Customer() {
    }

    public Customer(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object object) {

        if(this == object) return true;

        if(object == null || !(object instanceof Customer)) return false;

        Customer customer = (Customer) object;

        return name.equals(customer.name) &&
                email.equals(customer.email) &&
                account.equals(customer.account) &&
                phone.equals(customer.phone);

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, phone, account);
    }
    
}
