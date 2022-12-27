package com.example.loans.models;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private Integer id;
    

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "start_dt")
    private String startDt;

    @Column(name = "end_dt")
    private String endDt;

    @Column(name = "loan_type")
    private String loanType;

    @Column(name = "total_loan")
    private Integer totalLoan;

    @Column(name = "amount_paid")
    private Integer amountPaid;

    @Column(name = "outstanding_amount")
    private Integer outstandingAmount;

    @Column(name = "create_dt")
    private Date createDt;


    public Loan() {
    }

    public Loan(Integer customerId, String startDt, String endDt, String loanType, Integer totalLoan,
            Integer amountPaid, Integer outstandingAmount, Date createDt) {
        this.customerId = customerId;
        this.startDt = startDt;
        this.endDt = endDt;
        this.loanType = loanType;
        this.totalLoan = totalLoan;
        this.amountPaid = amountPaid;
        this.outstandingAmount = outstandingAmount;
        this.createDt = createDt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getStartDt() {
        return startDt;
    }

    public void setStartDt(String startDt) {
        this.startDt = startDt;
    }

    public String getEndDt() {
        return endDt;
    }

    public void setEndDt(String endDt) {
        this.endDt = endDt;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public Integer getTotalLoan() {
        return totalLoan;
    }

    public void setTotalLoan(Integer totalLoan) {
        this.totalLoan = totalLoan;
    }

    public Integer getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Integer amountPaid) {
        this.amountPaid = amountPaid;
    }


    public Integer getOutstandingAmount() {
        return outstandingAmount;
    }

    public void setOutstandingAmount(Integer outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
            return true;

        if (obj == null || !(obj instanceof Loan)) 
            return false;

        Loan loan = (Loan) obj;

        return id.equals(loan.id) && customerId.equals(loan.customerId) && startDt.equals(loan.startDt)
                && endDt.equals(loan.endDt) && loanType.equals(loan.loanType) && totalLoan.equals(loan.totalLoan)
                && amountPaid.equals(loan.amountPaid) && outstandingAmount.equals(loan.outstandingAmount)
                && createDt.equals(loan.createDt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, startDt, endDt, loanType, totalLoan, amountPaid, outstandingAmount, createDt);
    }


    @Override
    public String toString() {
        return "Loan [amountPaid=" + amountPaid + ", createDt=" + createDt + ", customerId=" + customerId + ", endDt="
                + endDt + ", id=" + id + ", loanType=" + loanType + ", outstandingAmount=" + outstandingAmount
                + ", startDt=" + startDt + ", totalLoan=" + totalLoan + "]";
    }

}
