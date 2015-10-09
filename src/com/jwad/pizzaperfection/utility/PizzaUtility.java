package com.jwad.pizzaperfection.utility;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.UUID;

import com.jwad.pizzaperfection.domainmodel.PizzaAddonsImpl;
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
	
	public static String deleteItemFromSession(String sessionkey, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.removeAttribute(sessionkey);
		return sessionkey;

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
	
	@SuppressWarnings("unchecked")
	public static ArrayList<PizzaAddonsImpl> getPizzaAddonsFromSession(String addonskey, HttpServletRequest request) {
		
		ArrayList<PizzaAddonsImpl> PizzaAddons = new ArrayList<PizzaAddonsImpl>();
		HttpSession session = request.getSession();
		PizzaAddons = (ArrayList<PizzaAddonsImpl>) session.getAttribute(addonskey);
		return PizzaAddons;
		
	}
	
	public static double totalAllPizzaAddons(ArrayList<PizzaAddonsImpl> PizzaAddons) {
		
		double total = 0;
		
		for (PizzaAddonsImpl addon: PizzaAddons) { 
			if (Double.parseDouble(addon.getPrice()) != 0) {
				total += Double.parseDouble(addon.getPrice());
			}
		}
		
		return total;
		
	}
	
	public static double totalAllPizzasFromSession(HttpServletRequest request) {
		
		double total = 0;
		HttpSession session = request.getSession();
		Enumeration<String> e = session.getAttributeNames();
		
		while (e.hasMoreElements()) { 
		    String name = (String)e.nextElement();
			if (session.getAttribute(name) instanceof PizzaImpl) {
				PizzaImpl pizza = (PizzaImpl) session.getAttribute(name);
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

	public static String writePizzaAddonsToSession(
			ArrayList<PizzaAddonsImpl> pizzaAddons, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String pizzaAddonsId = UUID.randomUUID().toString();
		session.setAttribute(pizzaAddonsId, pizzaAddons);
		return pizzaAddonsId;
		
	}

	public static String updatePizzaAddonsInSession( String pizzaAddonsId, ArrayList<PizzaAddonsImpl> pizzaAddons, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.setAttribute(pizzaAddonsId, pizzaAddons);
		return pizzaAddonsId;
		
	}
	
}
