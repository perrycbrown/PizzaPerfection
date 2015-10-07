package com.jwad.pizzaperfection.domainmodel;

public class PizzaAddonsImpl implements PizzaAddons {
	
	private String label;
	private String price;
	

	public PizzaAddonsImpl(String label, String price) {
		this.label = label;
		this.price = price;
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
		return "PizzaAddonsImpl [label=" + label + ", price=" + price
				+ "]";
	}

	@Override
	public void setPrice(double price) {
		// TODO Auto-generated method stub
		
	}

}
