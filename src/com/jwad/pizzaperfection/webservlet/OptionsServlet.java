package com.jwad.pizzaperfection.webservlet;
import javax.servlet.*;
import javax.servlet.http.*;

import com.jwad.pizzaperfection.domainmodel.PizzaElementImpl;
import com.jwad.pizzaperfection.domainmodel.PizzaImpl;
import com.jwad.pizzaperfection.domainmodel.PizzaSizeImpl;
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
 
    public void doPost(HttpServletRequest request,HttpServletResponse response)
                                        throws ServletException, IOException {
    	
		PizzaImpl pizza;
		PizzaServiceImpl pizzaService;
		ArrayList<PizzaSizeImpl> pizzasizes;
		HashMap<String, Double> pizzasizeshash;
		ArrayList<PizzaElementImpl> pizzaelements;
		HttpSession session = request.getSession();
		
		pizzaService = new PizzaServiceImpl();
		pizzasizes = pizzaService.getPizzaSizes();
		// Probably convert pizzasizes to a HashMap eventually for 
		// easier lookups? 
		pizzasizeshash = pizzaService.convertPizzaSizes(pizzasizes);
		session.setAttribute("pizzasizeshash", pizzasizes);
		
		// Load the element of our pizza, like different types of 
		// crust, sauce, cheese, etc.
		pizzaelements = pizzaService.getPizzaElements();
		session.setAttribute("pizzaelements", pizzaelements);
         
    	request.getRequestDispatcher("/Options.jsp").forward(request, response);
    	
    }
     
    
}
