package com.jwad.pizzaperfection.domainmodel;

public class PizzaElementImpl implements PizzaElement {
	
	private String type;
	private String label;
	private double price;


	public PizzaElementImpl (String type, String label, double price) {
		this.type = type;
		this.label = label;
		this.price = price;
	}

	public PizzaElementImpl() {
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "PizzaElementImpl [type=" + type + ", label=" + label
				+ ", price=" + price + "]";
	}

	@Override
	public void setElement(String type, String label, double price) {
		this.type = type;
		this.label = label;
		this.price = price;
	}


}
