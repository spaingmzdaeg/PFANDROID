package com.example.proyectofinal;

public class UserTransaction {

    private int transaction_id;
    private int user_id;
    private int amount;
    private String type;
    private String comment;
    private int payment_id;

    public UserTransaction(int transaction_id, int user_id, int amount, String type, String comment,int payment_id) {
        this.transaction_id = transaction_id;
        this.user_id = user_id;
        this.amount = amount;
        this.type = type;
        this.comment = comment;
        this.payment_id = payment_id;
    }

    public UserTransaction(){}

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }



    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "UserTransaction{" + "transaction_id=" + transaction_id + ", user_id=" + user_id + ", amount=" + amount + ", type=" + type + ", comment=" + comment + '}';
    }


}
