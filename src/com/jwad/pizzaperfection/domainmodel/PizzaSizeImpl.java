package com.jwad.pizzaperfection.domainmodel;

public class PizzaSizeImpl implements PizzaSize {
	
	private String label;
	private double multiplier;
	
	public PizzaSizeImpl(String label, double multiplier) {
		this.label = label;
		this.multiplier = multiplier;
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
	public void setMultiplier(double multiplier) {
		this.multiplier = multiplier;
	}

	@Override
	public double getMultiplier() {
		return this.multiplier;
	}

	@Override
	public String toString() {
		return "PizzaSizeImpl [label=" + label + ", multiplier=" + multiplier
				+ "]";
	}

}
