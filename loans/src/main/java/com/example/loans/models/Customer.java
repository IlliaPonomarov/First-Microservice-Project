package com.example.loans.models;

import java.util.Objects;

public class Customer {
    
    private int customerId;


    public Customer() {
    }

    public Customer(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Customer) || o == null) 
            return false;
        
        Customer customer = (Customer) o;
        return customerId == customer.customerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }

    @Override
    public String toString() {
        return "{" +
            " customerId='" + getCustomerId() + "'" +
            "}";
    }

}
