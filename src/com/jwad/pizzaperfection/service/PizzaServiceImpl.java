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
			
		//pizzasizes.add(new PizzaSizeImpl("small", 1.0));
		//pizzasizes.add(new PizzaSizeImpl("medium", 1.5));
		//pizzasizes.add(new PizzaSizeImpl("large", 2.0));
		//pizzasizes.add(new PizzaSizeImpl("extra large", 2.5));		
		//return pizzasizes;
		PizzaSizeDaoJdbcImpl PizzaSize = new PizzaSizeDaoJdbcImpl();
		return PizzaSize.list();
		
	}

	@Override
	public ArrayList<PizzaElementImpl> getPizzaElements(int complete) {

		//pizzaelements.add(new PizzaElementImpl("crust", "regular crust", 1.00));
		//pizzaelements.add(new PizzaElementImpl("crust", "thick crust", 2.00));
		//pizzaelements.add(new PizzaElementImpl("sauce", "regular sauce", 1.00));
		//pizzaelements.add(new PizzaElementImpl("sauce", "hot sauce", 2.00));
		//pizzaelements.add(new PizzaElementImpl("cheese", "regular cheese", 1.00));
		//pizzaelements.add(new PizzaElementImpl("cheese", "extra cheese", 2.00));
		//pizzaelements.add(new PizzaElementImpl("topping", "pepperoni", 1.00));
		//pizzaelements.add(new PizzaElementImpl("topping", "mushroom", 1.00));
		
		PizzaElementDaoJdbcImpl PizzaElements = new PizzaElementDaoJdbcImpl();
		return PizzaElements.list(complete);
		
	}
	
	public HashMap<String, Double> convertPizzaSizes(ArrayList<PizzaSizeImpl> pizzasizes) {
		
		for (PizzaSizeImpl size : pizzasizes) {
		   pizzasizeshash.put(size.getLabel(), size.getMultiplier());
		}
		return pizzasizeshash;

	}
	
	/*public PizzaImpl pizzaTest (ArrayList<PizzaElementImpl> pizzaelements, ArrayList<PizzaSizeImpl> pizzasizes) {
		
		pizza = new PizzaImpl(	pizzaelements.get(1).getLabel(), 
				pizzaelements.get(1).getPrice(), 
				pizzaelements.get(3).getLabel(), 
				pizzaelements.get(3).getPrice(), 
				pizzaelements.get(5).getLabel(), 
				pizzaelements.get(5).getPrice(),
				pizzaelements.get(7).getLabel(), 
				pizzaelements.get(7).getPrice(),
				pizzasizes.get(1).getMultiplier());
		
		return pizza;
		
	}*/
	
	public PizzaImpl createPizzaFromRequest (HttpServletRequest request) {
		
		if (request.getParameter("complete") != null && request.getParameter("complete_price") != null) {
			pizza = new PizzaImpl(request.getParameter("complete"),
					Double.parseDouble(request.getParameter("complete_price")) );
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
					Double.parseDouble(request.getParameter("size_price")) );
		}
		
		return pizza;
		
	}

}
