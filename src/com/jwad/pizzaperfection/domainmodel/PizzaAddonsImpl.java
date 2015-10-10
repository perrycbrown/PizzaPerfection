package com.jwad.pizzaperfection.domainmodel;

public class PizzaAddonsImpl implements PizzaAddons {
	
	private String label;
	private String price;
	private String type_label;
	private String id;
	private int quantity;
	

	public PizzaAddonsImpl(String id, String label, String price, String type_label) {
		this.id = id;
		this.label = label;
		this.price = price;
		this.type_label = type_label;
	}

	@Override
	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String getLabel() {
		return this.label;
	}

	@Override
	public String getPrice() {
		return this.price;
	}

	@Override
	public String toString() {
		return "PizzaAddonsImpl [id=" + id + ", label=" + label + ", price=" + price
				+ ", type_label=" + type_label + "]";
	}

	@Override
	public void setPrice(double price) {
		// TODO Auto-generated method stub
		
	}

	public String getType_label() {
		return type_label;
	}

	public void setType_label(String type_label) {
		this.type_label = type_label;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
