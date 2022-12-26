package com.micro.cards.models;



import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Integer cardId;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_type")
    private String cardType;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name ="total_limit")
    private Integer totalLimit;
    
    @Column(name = "available_amount")
    private Integer availableAmount;

    @Column(name = "amount_used")
    private Integer amountUsed;

    @Column(name = "create_dt")
    private Date createdDt;


    public Card() {
    }

    public Card(String cardNumber, String cardType, Long customerId, Integer totalLimit,Integer availableAmount, Integer amountUsed, Date createdDt) {
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.customerId = customerId;
        this.totalLimit = totalLimit;
        this.availableAmount = availableAmount;
        this.amountUsed = amountUsed;
        this.createdDt = createdDt;
    }
    
    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Integer getTotalLimit() {
        return totalLimit;
    }

    public void setTotalLimit(Integer totalLimit) {
        this.totalLimit = totalLimit;
    }

    public Integer getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(Integer availableAmount) {
        this.availableAmount = availableAmount;
    }

    public Integer getAmountUsed() {
        return amountUsed;
    }

    public void setAmountUsed(Integer amountUsed) {
        this.amountUsed = amountUsed;
    }

    public Date getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj) return true;

        if(obj == null || !(obj instanceof Card)) return false;

        Card card = (Card) obj;

        return cardId.equals(card.cardId) && cardNumber.equals(card.cardNumber) && cardType.equals(card.cardType) && customerId.equals(card.customerId) && totalLimit.equals(card.totalLimit) && availableAmount.equals(card.availableAmount) && amountUsed.equals(card.amountUsed) && createdDt.equals(card.createdDt);

    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, cardNumber, cardType, customerId, totalLimit, availableAmount, amountUsed, createdDt);
    }

    @Override
    public String toString() {
        return "Card [amountUsed=" + amountUsed + ", availableAmount=" + availableAmount + ", cardId=" + cardId
                + ", cardNumber=" + cardNumber + ", cardType=" + cardType + ", createdDt=" + createdDt + ", customerId="
                + customerId + ", totalLimit=" + totalLimit + "]";
    }

}
