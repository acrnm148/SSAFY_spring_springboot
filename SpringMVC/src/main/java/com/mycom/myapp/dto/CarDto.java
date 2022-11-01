package com.mycom.myapp.dto;

public class CarDto {
	private String name;
	private int price;
	private String ownerName;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	@Override
	public String toString() {
		return "CarDto [name=" + name + ", price=" + price + ", ownerName=" + ownerName + "]";
	}
	
}
