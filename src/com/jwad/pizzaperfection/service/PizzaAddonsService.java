package com.jwad.pizzaperfection.service;

import java.util.ArrayList;

import com.jwad.pizzaperfection.domainmodel.PizzaAddonsImpl;

public interface PizzaAddonsService {
	
	public ArrayList<PizzaAddonsImpl> getPizzaAddons(int type);

}
