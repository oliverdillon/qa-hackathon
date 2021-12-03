package com.qa.ims.persistence.domain;

public class Order {

    private Long orderId;
    private Long customerId;
    private Double totalPrice;

    public Order(Long orderId, Long customerId) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.totalPrice = 0.0;
    }

    public Order(Long customerId, Double totalPrice) {
        this.customerId = customerId;
        this.totalPrice = totalPrice;
    }

    public void setOrderID(Long orderId) {
        this.orderId = orderId;
    }

    public void setCustomer(Long customerId) {
        this.customerId = customerId;
    }

    public Double setTotalPrice(Double total) {
        this.totalPrice = total;
        return this.totalPrice;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Double getTotalPrice() {
        return this.totalPrice;
    }

    @Override
    public String toString() {
        return "Order id: " + orderId + " /nCustomer ID: " + customerId + " /n Total Price: £" + this.getTotalPrice();
    }
}
