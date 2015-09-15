package com.jwad.pizzaperfection.domainmodel;

public interface Pizza {
	
	public void setCrustType(String type);
	public String getCrustType();
	public void setSauceType(String type);
	public String getSauceType();
	public void setCheeseType(String type);
	public String getCheeseType();
	public void setToppingType(String type);
	public String getToppingType();
	public void setSize(double size);
	public double getSize();

}
