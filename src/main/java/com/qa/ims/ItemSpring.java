package com.qa.ims;

public class ItemSpring {

    private final Long id;
    private final String itemName;
    private final String itemValue;

    public ItemSpring(Long id, String itemName, String itemValue) {
        this.id = id;
        this.itemName = itemName;
        this.itemValue = itemValue;
    }
    public Long getId() {
        return id;
    }
    public String getItemName() {
        return itemName;
    }

    public String getItemValue() {
        return itemValue;
    }
}
