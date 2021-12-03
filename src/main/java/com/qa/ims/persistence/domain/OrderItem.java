package com.qa.ims.persistence.domain;

public class OrderItem {

    private Long orderItemId;
    private Long orderId;
    private Long itemId;

    public OrderItem(Long OrderItemId, Long orderId, Long itemId) {
        this.orderItemId = OrderItemId;
        this.orderId = orderId;
        this.itemId = itemId;
    }

    public OrderItem(Long orderId, Long itemId) {
        this.orderId = orderId;
        this.itemId = itemId;
    }

    public void setOrderItemId(Long OrderItemId) {
        this.orderItemId = OrderItemId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getItemId() {
        return itemId;
    }

    
}
