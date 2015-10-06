package com.jwad.pizzaperfection.utility;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.UUID;
import com.jwad.pizzaperfection.domainmodel.PizzaImpl;

public class PizzaUtility {

	public static String writePizzaToSession(PizzaImpl pizza, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String pizzaid = UUID.randomUUID().toString();
		session.setAttribute(pizzaid, pizza);
		return pizzaid;

	}
	
	public static String updatePizzaInSession(String pizzaid, PizzaImpl pizza, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.setAttribute(pizzaid, pizza);
		return pizzaid;

	}
	
	public static PizzaImpl getPizzaFromSession(String index, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		if (session.getAttribute(index) != null) {
			return (PizzaImpl) session.getAttribute(index);
		}
		else {
			return null;
		}
		
	}
	
	public static String deletePizzaFromSession(String pizzaid, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.removeAttribute(pizzaid);
		return pizzaid;

	}
	
	public static HashMap<String, PizzaImpl> getAllPizzasFromSession(HttpServletRequest request) {
		
		HashMap<String, PizzaImpl> AllPizzas = new HashMap<String, PizzaImpl>();
		HttpSession session = request.getSession();
		Enumeration<String> e = session.getAttributeNames();
		while (e.hasMoreElements()) {
			String key = (String)e.nextElement();
			if (session.getAttribute(key) instanceof PizzaImpl) {
				AllPizzas.put(key, (PizzaImpl) session.getAttribute(key));
			}
		}
		
		return AllPizzas;
		
	}
	
	public static double totalAllPizzasFromSession(HttpServletRequest request) {
		
		double total = 0;
		HttpSession session = request.getSession();
		Enumeration<String> e = session.getAttributeNames();
		
		while (e.hasMoreElements()) { 
		    String name = (String)e.nextElement();
			if (session.getAttribute(name) instanceof PizzaImpl) {
				PizzaImpl pizza = (PizzaImpl) session.getAttribute(name);
				System.out.println("Got the pizza: " + pizza);
				System.out.println("Here is complete price: " + pizza.calcPrice());
				System.out.println("Here is quantity: " + pizza.getPizzaQuantity());
				System.out.println("Here is complete price: " + pizza.calcCompletePrice());
				if (pizza.calcPrice() != 0) {
					total += (Double) pizza.calcPrice();
				}
				else if (pizza.calcCompletePrice() != 0) {
					total += (Double) pizza.calcCompletePrice();
				}
			}
		}
		
		return total;
		
	}

	public static boolean indexInSession(String index, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		if (session.getAttribute(index) != null) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
}
