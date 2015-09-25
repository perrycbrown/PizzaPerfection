package com.jwad.pizzaperfection.webservlet;
import javax.servlet.*;
import javax.servlet.http.*;

import com.jwad.pizzaperfection.domainmodel.PizzaElementImpl;
import com.jwad.pizzaperfection.domainmodel.PizzaSizeImpl;
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
    	
		PizzaServiceImpl pizzaService;
		ArrayList<PizzaSizeImpl> pizzasizes;
		ArrayList<PizzaElementImpl> pizzaelements;
		HttpSession session = request.getSession();
		
		pizzaService = new PizzaServiceImpl();
		pizzasizes = pizzaService.getPizzaSizes();
		pizzaService.convertPizzaSizes(pizzasizes);
		session.setAttribute("pizzasizeshash", pizzasizes);
		
		// Load the element of our pizza, like different types of 
		// crust, sauce, cheese, etc. No complete pizzas here, though.
		pizzaelements = pizzaService.getPizzaElements(2);
		session.setAttribute("pizzaelements", pizzaelements);
         
    	request.getRequestDispatcher("/Options.jsp").forward(request, response);
    	
    }
     
    
}
