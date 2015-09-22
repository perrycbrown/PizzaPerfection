package com.jwad.pizzaperfection.webservlet;
import javax.servlet.*;
import javax.servlet.http.*;

import com.jwad.pizzaperfection.domainmodel.PizzaImpl;
import com.jwad.pizzaperfection.service.PizzaServiceImpl;

import java.io.*;
import java.util.HashMap;
 
 
@SuppressWarnings("serial")
public class ReviewServlet extends HttpServlet {
 
    public void doGet(HttpServletRequest request,HttpServletResponse response)
                                         throws ServletException, IOException {
        doPost(request, response);
    }
 
    public void doPost(HttpServletRequest request,HttpServletResponse response)
                                        throws ServletException, IOException {
    	PizzaServiceImpl pizzaService;
    	pizzaService = new PizzaServiceImpl();
    	// Gather incoming pizza order info into a pizza object, and calculate
    	// price also:
    	PizzaImpl pizza = pizzaService.createPizzaFromRequest(request);
    	System.out.println("Here is pizza: " + pizza);
    	Double total = pizza.getTotalPrice();
    	request.setAttribute("total",String.format("%1$,.2f", total));
     	 
    	//Write to a session:
    	HttpSession session = request.getSession();
    	session.setAttribute("pizza", pizza);
    	
    	request.getRequestDispatcher("/Review.jsp").forward(request, response);
    	
    }
     
    
}
