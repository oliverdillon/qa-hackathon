package com.qa.ims.persistence.domain;

public class Item {
    private Long ItemID;
	private String Name;
	private Double Price;
    
    public Item(String name, Double price) {
		this.setName(name);
		this.setPrice(price);
	}

	public Item(Long id, String name, Double price) {
		this.setItemID(id);
		this.setName(name);
		this.setPrice(price);
	}

    public void setItemID(Long ItemID){
         this.ItemID = ItemID;
    }
    public void setName(String name){
        this.Name = name;
    }
    public void setPrice(Double price){
        this.Price = price;
    }

    public Long getItemID(){
        return ItemID;
    }
    public String getName(){
        return Name;
    }
    public Double getPrice(){
        return Price;
    }

    @Override
	public String toString() {
		return "id:" + ItemID + " name:" + Name + " price:" + Price;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (getItemID() == null) {
			if (other.getItemID() != null)
				return false;
		} else if (!getItemID().equals(other.getItemID()))
			return false;
		if (Name == null) {
			if (other.getName() != null)
				return false;
		} else if (!getName().equals(other.getName()))
			return false;
		if (Price == null) {
			if (other.getPrice() != null)
				return false;
		} else if (!getPrice().equals(other.getPrice()))
			return false;
		return true;
	}

    
}
