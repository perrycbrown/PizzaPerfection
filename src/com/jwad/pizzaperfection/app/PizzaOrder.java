package com.jwad.pizzaperfection.app;

import java.util.ArrayList;
import java.util.HashMap;

import com.jwad.pizzaperfection.domainmodel.PizzaElementImpl;
import com.jwad.pizzaperfection.domainmodel.PizzaImpl;
import com.jwad.pizzaperfection.domainmodel.PizzaSizeImpl;
import com.jwad.pizzaperfection.service.PizzaServiceImpl;

public class PizzaOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		PizzaImpl pizza;
		PizzaServiceImpl pizzaService;
		ArrayList<PizzaSizeImpl> pizzasizes;
		HashMap<String, Double> pizzasizeshash;
		ArrayList<PizzaElementImpl> pizzaelements;
		ArrayList<PizzaElementImpl> pizzacompleteelements;
		
		pizzaService = new PizzaServiceImpl();
		pizzasizes = pizzaService.getPizzaSizes();
		System.out.println(pizzasizes);
		
		// Probably convert pizzasizes to a HashMap eventually for 
		// easier lookups? 
		pizzasizeshash = pizzaService.convertPizzaSizes(pizzasizes);
		System.out.println(pizzasizeshash);
		
		// Load the element of our pizza, like different types of 
		// crust, sauce, cheese, etc.
		pizzaelements = pizzaService.getPizzaElements(2);
		System.out.println(pizzaelements);
		
		pizzaelements = pizzaService.getPizzaElements(2);
		System.out.println(pizzaelements);
		
		pizzacompleteelements = pizzaService.getPizzaElements(3);
		System.out.println(pizzacompleteelements);
		
		// Create a pizza, to see a test PizzaImpl object:
		//pizza = pizzaService.pizzaTest(pizzaelements, pizzasizes);
		
		//System.out.println(pizza);
		//System.out.println("Total cost is: " + pizza.calcPrice());
		
		
	}

}
