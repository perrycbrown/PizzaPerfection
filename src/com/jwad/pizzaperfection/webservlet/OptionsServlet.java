package com.jwad.pizzaperfection.webservlet;
import javax.servlet.*;
import javax.servlet.http.*;

import com.jwad.pizzaperfection.domainmodel.PizzaAddonsImpl;
import com.jwad.pizzaperfection.domainmodel.PizzaElementImpl;
import com.jwad.pizzaperfection.domainmodel.PizzaImpl;
import com.jwad.pizzaperfection.domainmodel.PizzaSizeImpl;
import com.jwad.pizzaperfection.service.PizzaAddonsServiceImpl;
import com.jwad.pizzaperfection.service.PizzaServiceImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
 
 
@SuppressWarnings("serial")
public class OptionsServlet extends HttpServlet {
 
    public void doGet(HttpServletRequest request,HttpServletResponse response)
                                         throws ServletException, IOException {
    	
    	doPost(request, response);
        
    }
 
    @SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request,HttpServletResponse response)
                                        throws ServletException, IOException {
    	
    	String completeClass = "";
    	String pizzaClass = "active";
    	String addonsClass = "";
    	String buildapizzaTitle = "Add a pizza by choosing these options:";
    	String completepizzaTitle = "Add a complete pizza:";
    	String addonsTitle = "Add one or more to your order:";
		PizzaServiceImpl pizzaService;
		ArrayList<PizzaSizeImpl> pizzasizes;
		ArrayList<PizzaElementImpl> pizzaelements;
		ArrayList<PizzaElementImpl> pizzacomplete;
		HttpSession session = request.getSession();
		
		pizzaService = new PizzaServiceImpl();
		
		// Get the pizza sizes
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
			
			addonsTitle = "Modify your addons here:";
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
       	getServletContext().getRequestDispatcher("/WEB-INF/Options.jsp").forward(request,  response);
    	
    }
    
}
