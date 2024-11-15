package com.example.appfood.Domain;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private int idHotel;
    private int quantity;

    private double totalPrice;
    private String customerId;
    private String customerName;
    private String nameHotel;
    private String phone;
    private Date date;

    public Order(int idHotel, String nameHotel, int quantity, double totalPrice, String customerId, String customerName, String phone, Date date) {
        this.idHotel = idHotel;
        this.quantity = quantity;
        this.nameHotel = nameHotel;
        this.totalPrice = totalPrice;
        this.customerName = customerName;
        this.customerId = customerId;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getNameHotel() {
        return nameHotel;
    }

    public void setNameHotel(String nameHotel) {
        this.nameHotel = nameHotel;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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
