package com.jwad.pizzaperfection.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.jwad.pizzaperfection.domainmodel.PizzaElementImpl;
import com.jwad.pizzaperfection.domainmodel.PizzaSizeImpl;

public interface PizzaService {
	
	public ArrayList<PizzaSizeImpl> getPizzaSizes();
	public ArrayList<PizzaElementImpl> getPizzaElements();

}
