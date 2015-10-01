package com.jwad.pizzaperfection.domainmodel;

public class PizzaImpl implements Pizza {
	
	private String crustType;
	private double crustPrice;
	private String sauceType;
	private double saucePrice;
	private String cheeseType;
	private double cheesePrice;
	private String toppingType;
	private double toppingPrice;
	private double pizzaSize;
	private double totalPrice;
	private String completeType = "";
	private double completePrice;
	
	public PizzaImpl(String crustType, 
					double crustPrice, 
					String sauceType, 
					double saucePrice, 
					String cheeseType, 
					double cheesePrice, 
					String toppingType, 
					double toppingPrice,
					double pizzaSize) {
		
		this.crustType = crustType;
		this.crustPrice = crustPrice;
		this.sauceType = sauceType;
		this.saucePrice = saucePrice;
		this.cheeseType = cheeseType;
		this.cheesePrice = cheesePrice;
		this.toppingType = toppingType;
		this.toppingPrice = toppingPrice;
		this.pizzaSize = pizzaSize;
		this.totalPrice = calcPrice();
		
	}
	
	public PizzaImpl(String completeType,
					double completePrice) {
		
		this.setCompleteType(completeType);
		this.setCompletePrice(completePrice);
		this.totalPrice = completePrice;
		
	}

	public PizzaImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setCrustType(String type) {
		this.crustType = type;
	}

	@Override
	public String getCrustType() {
		return this.crustType;
	}
	
	public void setCrustPrice(Double price) {
		this.crustPrice = price;
	}

	public Double getCrustPrice() {
		return this.crustPrice;
	}

	@Override
	public void setSauceType(String type) {
		this.sauceType = type;
	}

	@Override
	public String getSauceType() {
		return this.sauceType;
	}
	
	public void setSaucePrice(Double price) {
		this.saucePrice = price;
	}

	public double getSaucePrice() {
		return this.saucePrice;
	}

	@Override
	public void setCheeseType(String type) {
		this.cheeseType = type;
	}

	@Override
	public String getCheeseType() {
		return this.cheeseType;
	}

	@Override
	public void setToppingType(String type) {
		this.toppingType = type;
	}

	@Override
	public String getToppingType() {
		return this.toppingType;
	}

	@Override
	public void setSize(double size) {
		this.pizzaSize = size;
	}

	@Override
	public double getSize() {
		return this.pizzaSize;
	}
	
	public void setTotalPrice(double price) {
		this.totalPrice = price;
	}

	public double getTotalPrice() {
		return this.totalPrice;
	}
	
	
	public double calcPrice() {
		return  (( this.cheesePrice + this.crustPrice + this.saucePrice + this.toppingPrice ) * this.pizzaSize);
	}

	@Override
	public String toString() {
		return "PizzaImpl [crustType=" + crustType + ", crustPrice="
				+ crustPrice + ", sauceType=" + sauceType + ", saucePrice="
				+ saucePrice + ", cheeseType=" + cheeseType + ", cheesePrice="
				+ cheesePrice + ", toppingType=" + toppingType
				+ ", toppingPrice=" + toppingPrice + ", pizzaSize=" + pizzaSize
				+ "]";
	}

	public String getCompleteType() {
		return this.completeType;
	}

	public void setCompleteType(String completeType) {
		this.completeType = completeType;
	}

	public double getCompletePrice() {
		return this.completePrice;
	}

	public void setCompletePrice(double completePrice) {
		this.completePrice = completePrice;
	}

}
