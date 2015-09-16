package com.jwad.pizzaperfection.app;

import java.util.ArrayList;
import java.util.HashMap;

import com.jwad.pizzaperfection.domainmodel.PizzaElementImpl;
import com.jwad.pizzaperfection.domainmodel.PizzaImpl;
import com.jwad.pizzaperfection.domainmodel.PizzaSizeImpl;

public class PizzaOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		PizzaImpl pizza;
		
		ArrayList<PizzaSizeImpl> pizzasizes = new ArrayList<PizzaSizeImpl>();	
		pizzasizes.add(new PizzaSizeImpl("small", 0));
		pizzasizes.add(new PizzaSizeImpl("medium", 1.5));
		pizzasizes.add(new PizzaSizeImpl("large", 2.0));
		pizzasizes.add(new PizzaSizeImpl("extra large", 2.5));
		
		// Probably convert pizzasizes to a HashMap eventually for 
		// easier lookups?
		// HashMap<String, Double> pizzaSizes = pizzaService.getPizzaSizes();
		// ArrayList<PizzaElementImpl> pizzasElements = pizzaService.getPizzaElemets();
		HashMap<String, Double> pizzasizeshash = new HashMap<String, Double>();
		for (Object size : pizzasizes) {
		   pizzasizeshash.put(((PizzaSizeImpl) size).getLabel(), ((PizzaSizeImpl) size).getMultiplier());
		}
		
		System.out.println(pizzasizeshash);
		
		ArrayList<PizzaElementImpl> pizzaelements = new ArrayList<PizzaElementImpl>();
		pizzaelements.add(new PizzaElementImpl("crust", "regular crust", 1.00));
		pizzaelements.add(new PizzaElementImpl("crust", "thick crust", 2.00));
		pizzaelements.add(new PizzaElementImpl("sauce", "regular sauce", 1.00));
		pizzaelements.add(new PizzaElementImpl("sauce", "hot sauce", 2.00));
		pizzaelements.add(new PizzaElementImpl("cheese", "regular cheese", 1.00));
		pizzaelements.add(new PizzaElementImpl("cheese", "extra cheese", 2.00));
		pizzaelements.add(new PizzaElementImpl("topping", "pepperoni", 1.00));
		pizzaelements.add(new PizzaElementImpl("topping", "mushroom", 1.00));
		
		System.out.println(pizzaelements);
		
		pizza = new PizzaImpl(	pizzaelements.get(1).getLabel(), 
								pizzaelements.get(1).getPrice(), 
								pizzaelements.get(3).getLabel(), 
								pizzaelements.get(3).getPrice(), 
								pizzaelements.get(5).getLabel(), 
								pizzaelements.get(5).getPrice(),
								pizzaelements.get(7).getLabel(), 
								pizzaelements.get(7).getPrice(),
								pizzasizes.get(1).getMultiplier());
		
		System.out.println(pizza);
		System.out.println("Total cost is: " + pizza.calcPrice());
		
	}

}
