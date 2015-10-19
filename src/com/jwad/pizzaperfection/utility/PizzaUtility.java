package com.jwad.pizzaperfection.utility;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.UUID;

import com.jwad.pizzaperfection.domainmodel.PizzaAddonsImpl;
import com.jwad.pizzaperfection.domainmodel.PizzaImpl;
import com.jwad.pizzaperfection.service.PizzaAddonsServiceImpl;

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
	
	@SuppressWarnings("unchecked")
	public static HttpServletRequest loadFromIds (HttpServletRequest request) {
		
    	String completeClass = "";
    	String pizzaClass = "active";
    	String addonsClass = "";
    	String buildapizzaTitle = "Add a pizza by choosing these options:";
    	String completepizzaTitle = "Add a complete pizza:";
    	String addonsTitle = "Add one or more extras to your order:";
    	
    	PizzaAddonsServiceImpl pizzaAddonsService;
    	pizzaAddonsService = new PizzaAddonsServiceImpl();

		HttpSession session = request.getSession();
		// If a pizza id is incoming from form, load that pizza
		// from session so it can be edited.
		if (request.getParameterMap().containsKey("pizzaid") && 
				!((String) request.getParameter("pizzaid")).isEmpty()) {
			PizzaImpl pizza = (PizzaImpl) session.getAttribute((String) request.getParameter("pizzaid"));
			request.setAttribute("pizza", pizza);
			request.setAttribute("pizzaid",request.getParameter("pizzaid"));
			
			completepizzaTitle = "Change to a complete pizza:";
			buildapizzaTitle = "Modify your build-a-pizza:";
			
			if (pizza instanceof PizzaImpl){
				if (!pizza.getCompleteType().equals("")) {
					completeClass = "active";
					pizzaClass = "";
					completepizzaTitle = "Modify your complete pizza:";
					buildapizzaTitle = "Change to a build-a-pizza:";
				}
			}
		}
		
		// If an addons id is incoming from form, load that addons ArrayList
		// from session so it can be edited.
		else if (request.getParameterMap().containsKey("addonsid") && 
				!((String) request.getParameter("addonsid")).isEmpty()) {
			ArrayList<PizzaAddonsImpl> pizzaAddons = (ArrayList<PizzaAddonsImpl>) session.getAttribute((String) request.getParameter("addonsid"));
			HashMap<String, String> ids = pizzaAddonsService.extractIds(pizzaAddons);
			//request.setAttribute("pizzaaddons", pizzaAddons);
			//System.out.println("Here is pizzaAddons: " + pizzaAddons);
			request.setAttribute("requestedaddonsids", ids);
			request.setAttribute("addonsid",request.getParameter("addonsid"));
			completeClass = "";
			pizzaClass = "";
			addonsClass = "active";
			
			addonsTitle = "Modify your extras here:";
			completepizzaTitle = "Add a complete pizza:";
			buildapizzaTitle = "Add a build-a-pizza:";
		}
		
		// Or just load a new form to create a new pizza:
		else {
			PizzaImpl pizza = new PizzaImpl();
			request.setAttribute("pizzaid","");
			request.setAttribute("pizza", pizza);
		}

		request.setAttribute("completeClass", completeClass);
		request.setAttribute("pizzaClass", pizzaClass);
		request.setAttribute("addonsClass", addonsClass);
		request.setAttribute("addonsTitle", addonsTitle);
		request.setAttribute("completepizzaTitle", completepizzaTitle);
		request.setAttribute("buildapizzaTitle", buildapizzaTitle);
		
		return request;
	}
	
}
