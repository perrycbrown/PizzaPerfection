package com.jwad.pizzaperfection.service;

import java.util.ArrayList;
import com.jwad.pizzaperfection.domainmodel.PizzaElementImpl;
import com.jwad.pizzaperfection.domainmodel.PizzaSizeImpl;

public interface PizzaService {
	
	public ArrayList<PizzaSizeImpl> getPizzaSizes();
	public ArrayList<PizzaElementImpl> getPizzaElements(int complete);

}
