package com.jwad.pizzaperfection.webservlet;
import javax.servlet.*;
import javax.servlet.http.*;

import com.jwad.pizzaperfection.domainmodel.PizzaImpl;
import com.jwad.pizzaperfection.service.PizzaServiceImpl;
import com.jwad.pizzaperfection.utility.PizzaUtility;

import java.io.*;
 
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
    	Double total = pizza.getTotalPrice();
    	request.setAttribute("total",String.format("%1$,.2f", total));
     	 
    	//Write to a session:
    	//HttpSession session = request.getSession();
    	//session.setAttribute("pizza", pizza);
    	String pizzaid = PizzaUtility.writePizzaToSession(pizza, request);
    	System.out.println("Here is id: " + pizzaid);
    	request.setAttribute("pizzaid", pizzaid);
       	getServletContext().getRequestDispatcher("/WEB-INF/Review.jsp").forward(request, response);
    	
    }
 
}
