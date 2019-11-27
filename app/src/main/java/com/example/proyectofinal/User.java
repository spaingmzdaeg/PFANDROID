package com.example.proyectofinal;

public class User {
    private int user_id;
    private String email;
    private String password;
    private String first_name;
    private String last_name;
    private String address;
    private String performance_factor;
    private String cellphone;
    private int payment_id;

    public User(){}

    public User(int user_id, String email, String password, String first_name, String last_name, String address, String performance_factor, String cellphone, int payment_id) {
        this.user_id = user_id;
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.performance_factor = performance_factor;
        this.cellphone = cellphone;
        this.payment_id = payment_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPerformance_factor() {
        return performance_factor;
    }

    public void setPerformance_factor(String performance_factor) {
        this.performance_factor = performance_factor;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    @Override
    public String toString() {
        return "User{" + "user_id=" + user_id + ", email=" + email + ", password=" + password + ", first_name=" + first_name + ", last_name=" + last_name + ", address=" + address + ", performance_factor=" + performance_factor + ", cellphone=" + cellphone + ", payment_id=" + payment_id + '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
