package model;

import java.time.LocalDateTime;

public class Customer {
    private long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private boolean status;
    private boolean blockStatus;
    private LocalDateTime registerDate;
    private LocalDateTime updateDate;
    private Card card;
    private byte blocAttempts;


    public byte getBlocAttempts() {
        return blocAttempts;
    }

    public void setBlocAttempts(byte blocAttempts) {
        this.blocAttempts = blocAttempts;
    }

    public Customer(long id, String name, String surname, String email, String password, boolean status, boolean blockStatus, LocalDateTime registerDate, LocalDateTime updateDate, Card card, byte blocAttempts) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.status = status;
        this.blockStatus = blockStatus;
        this.registerDate = registerDate;
        this.updateDate = updateDate;
        this.card = card;
        this.blocAttempts = blocAttempts;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isBlockStatus() {
        return blockStatus;
    }

    public void setBlockStatus(boolean blockStatus) {
        this.blockStatus = blockStatus;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", blockStatus=" + blockStatus +
                ", registerDate=" + registerDate +
                ", updateDate=" + updateDate +
                ", card Number=" + card.getCardNumber() +
                '}';
    }

    public String getInfo(){
        return "Customer{" +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\''+
                ", card number=" + card.getCardNumber() +
                ", card balance=" + card.getCurrentBalance();
    }
}
