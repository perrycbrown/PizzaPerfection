package com.jwad.pizzaperfection.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.jwad.pizzaperfection.dao.PizzaElementDaoJdbcImpl;
import com.jwad.pizzaperfection.dao.PizzaSizeDaoJdbcImpl;
import com.jwad.pizzaperfection.domainmodel.PizzaElementImpl;
import com.jwad.pizzaperfection.domainmodel.PizzaImpl;
import com.jwad.pizzaperfection.domainmodel.PizzaSizeImpl;

public class PizzaServiceImpl implements PizzaService {
	
	HashMap<String, Double> pizzasizeshash = new HashMap<String, Double>();
	ArrayList<PizzaSizeImpl> pizzasizes = new ArrayList<PizzaSizeImpl>();
	ArrayList<PizzaElementImpl> pizzaelements = new ArrayList<PizzaElementImpl>();
	PizzaImpl pizza;

	public PizzaServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<PizzaSizeImpl> getPizzaSizes() {
			
		PizzaSizeDaoJdbcImpl PizzaSize = new PizzaSizeDaoJdbcImpl();
		return PizzaSize.list();
		
	}

	@Override
	public ArrayList<PizzaElementImpl> getPizzaElements(int complete) {

		PizzaElementDaoJdbcImpl PizzaElements = new PizzaElementDaoJdbcImpl();
		return PizzaElements.list(complete);
		
	}
	
	public HashMap<String, Double> convertPizzaSizes(ArrayList<PizzaSizeImpl> pizzasizes) {
		
		for (PizzaSizeImpl size : pizzasizes) {
		   pizzasizeshash.put(size.getLabel(), size.getMultiplier());
		}
		return pizzasizeshash;

	}
	
	public PizzaImpl createPizzaFromRequest (HttpServletRequest request) {
		
		if (request.getParameter("complete") != null && request.getParameter("complete_price") != null) {
			pizza = new PizzaImpl(request.getParameter("complete"),
					Double.parseDouble(request.getParameter("complete_price")),
					Integer.parseInt(request.getParameter("quantity")));
		}
		else {
			pizza = new PizzaImpl(request.getParameter("crust"),
					Double.parseDouble(request.getParameter("crust_price")), 
					request.getParameter("sauce"), 
					Double.parseDouble(request.getParameter("sauce_price")), 
					request.getParameter("cheese"),
					Double.parseDouble(request.getParameter("cheese_price")),
					request.getParameter("topping"), 
					Double.parseDouble(request.getParameter("topping_price")),
					request.getParameter("size"),
					Double.parseDouble(request.getParameter("size_price")),
					Integer.parseInt(request.getParameter("quantity")));
		}
		
		return pizza;
		
	}

}
