package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Card {
    private long id;
    private String cardNumber;
    private double currentBalance;
    private LocalDateTime updateTime;

    public Card(long id, String cardNumber, double currentBalance, LocalDateTime updateTime) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.currentBalance = currentBalance;
        this.updateTime = updateTime;
    }

    public long getId() {
        return id;
    }



    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

}
