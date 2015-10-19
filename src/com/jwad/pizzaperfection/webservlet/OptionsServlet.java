package com.jwad.pizzaperfection.webservlet;
import javax.servlet.*;
import javax.servlet.http.*;

import com.jwad.pizzaperfection.domainmodel.PizzaAddonsImpl;
import com.jwad.pizzaperfection.domainmodel.PizzaElementImpl;
import com.jwad.pizzaperfection.domainmodel.PizzaSizeImpl;
import com.jwad.pizzaperfection.service.PizzaAddonsServiceImpl;
import com.jwad.pizzaperfection.service.PizzaServiceImpl;
import com.jwad.pizzaperfection.utility.PizzaUtility;

import java.io.*;
import java.util.ArrayList;
 
 
@SuppressWarnings("serial")
public class OptionsServlet extends HttpServlet {
 
    public void doGet(HttpServletRequest request,HttpServletResponse response)
                                         throws ServletException, IOException {
    	
    	doPost(request, response);
        
    }
 
	public void doPost(HttpServletRequest request,HttpServletResponse response)
                                        throws ServletException, IOException {
    	
		PizzaServiceImpl pizzaService;
		ArrayList<PizzaSizeImpl> pizzasizes;
		ArrayList<PizzaElementImpl> pizzaelements;
		ArrayList<PizzaElementImpl> pizzacomplete;
		HttpSession session = request.getSession();
		
		// Get the pizza sizes
		pizzaService = new PizzaServiceImpl();
		pizzasizes = pizzaService.getPizzaSizes();
		pizzaService.convertPizzaSizes(pizzasizes);
		session.setAttribute("pizzasizeshash", pizzasizes);
		
		// Load the elements of our pizza, like different types of 
		// crust, sauce, cheese, etc. No complete pizzas here, though.
		pizzaelements = pizzaService.getPizzaElements(2);
		session.setAttribute("pizzaelements", pizzaelements);
		
		// Load the complete pizzas here.
		pizzacomplete = pizzaService.getPizzaElements(3);
		session.setAttribute("pizzacomplete", pizzacomplete);
		
		// Load the addons (drinks, bread, desserts, etc) here
		PizzaAddonsServiceImpl pizzaAddonsService;
		pizzaAddonsService = new PizzaAddonsServiceImpl();
		ArrayList<PizzaAddonsImpl> pizzaaddons = pizzaAddonsService.getPizzaAddons(0);
		session.setAttribute("pizzaaddons", pizzaaddons);
		
		// Check incoming pizza or addon ids and modify request accordingly:
		request = PizzaUtility.loadFromIds(request);
		
       	getServletContext().getRequestDispatcher("/WEB-INF/Options.jsp").forward(request,  response);
    	
    }
    
}
