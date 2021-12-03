package com.qa.ims;

public class OrderSpring {
    private final Long id;
    private final Long customerId;
    private final Long totalCost;

    public OrderSpring(Long id, Long customerId, Long totalCost) {
        this.id = id;
        this.customerId = customerId;
        this.totalCost = totalCost;
    }
    public Long getId() {
        return id;
    }
    public Long getCustomerId() {
        return customerId;
    }

    public Long getTotalCost() {
        return totalCost;
    }

}
