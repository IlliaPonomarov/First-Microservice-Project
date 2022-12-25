package com.micro.account.models;

import java.util.Date;
import java.util.Objects;

import com.example.demo.util.enums.AccountType;
import jakarta.persistence.*;


@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "account_type")
    @Enumerated(EnumType.ORDINAL)
    private AccountType accountType;

    @Column(name = "branch_address")
    private String branchAddress;

    @OneToOne(mappedBy = "account")
    private Customer customerId;

    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    public Account() {
    }

    public Account(AccountType accountType, String branchAddress, Customer customerId, Date createdAt) {
        this.accountType = accountType;
        this.branchAddress = branchAddress;
        this.customerId = customerId;
        this.createdAt = createdAt;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Account)) return false;

        Account account = (Account) o;

        return  this.accountType.equals(account.accountType) &&
                this.branchAddress.equals(account.branchAddress) && 
                this.customerId.equals(account.customerId) &&
                this.createdAt.equals(account.createdAt);
    }


    @Override
    public int hashCode() {
        return Objects.hash(accountType, branchAddress, customerId, createdAt);
    }
}
