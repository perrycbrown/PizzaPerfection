package com.jwad.pizzaperfection.utility;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.UUID;
import com.jwad.pizzaperfection.domainmodel.PizzaImpl;

public class PizzaUtility {

	public static String writePizzaToSession(PizzaImpl pizza, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String pizzaid = UUID.randomUUID().toString();
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
	
	public static ArrayList<PizzaImpl> getAllPizzasFromSession(HttpServletRequest request) {
		
		ArrayList<PizzaImpl> AllPizzas = new ArrayList<PizzaImpl>();
		HttpSession session = request.getSession();
		Enumeration<String> e = session.getAttributeNames();
		while (e.hasMoreElements()) {
			String key = (String)e.nextElement();
			if (session.getAttribute(key) instanceof PizzaImpl) {
				AllPizzas.add((PizzaImpl) session.getAttribute(key));
			}
		}
		
		return AllPizzas;
		
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
