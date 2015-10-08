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
 
 
@SuppressWarnings("serial")
public class OptionsServlet extends HttpServlet {
 
    public void doGet(HttpServletRequest request,HttpServletResponse response)
                                         throws ServletException, IOException {
    	
    	doPost(request, response);
        
    }
 
    public void doPost(HttpServletRequest request,HttpServletResponse response)
                                        throws ServletException, IOException {
    	
    	String completeClass = "";
    	String pizzaClass = "active";
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
			
			if (pizza instanceof PizzaImpl){
				if (!pizza.getCompleteType().equals("")) {
					completeClass = "active";
					pizzaClass = "";
				}
			}
		}
		
		// Or just load a new form to create a new pizza:
		else {
			PizzaImpl pizza = new PizzaImpl();
			request.setAttribute("pizzaid","");
			request.setAttribute("pizza", pizza);
		}

		request.setAttribute("completeClass", completeClass);
		request.setAttribute("pizzaClass", pizzaClass);
       	getServletContext().getRequestDispatcher("/WEB-INF/Options.jsp").forward(request,  response);
    	
    }
    
}
