package com.example.appfood.Domain;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private int idHotel;
    private double totalPrice;
    private String customerName;
    private String phone;
    private Date date;

    public Order(int idHotel, double totalPrice, String customerName, String phone, Date date) {
        this.idHotel = idHotel;
        this.totalPrice = totalPrice;
        this.customerName = customerName;
        this.phone = phone;
        this.date = date;
    }

    // Getters and Setters
    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Order() {
    }
    // toString Method
    @Override
    public String toString() {
        return "Order{" +
                "idHotel=" + idHotel +
                ", totalPrice=" + totalPrice +
                ", customerName='" + customerName + '\'' +
                ", phone='" + phone + '\'' +
                ", date=" + date +
                '}';
    }
}
