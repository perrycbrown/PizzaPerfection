package com.jwad.pizzaperfection.webservlet;
import javax.servlet.*;
import javax.servlet.http.*;

import com.jwad.pizzaperfection.domainmodel.PizzaElementImpl;
import com.jwad.pizzaperfection.domainmodel.PizzaImpl;
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
    	
    	String completeClass = "";
    	String pizzaClass = "active";
		PizzaServiceImpl pizzaService;
		ArrayList<PizzaSizeImpl> pizzasizes;
		ArrayList<PizzaElementImpl> pizzaelements;
		ArrayList<PizzaElementImpl> pizzacomplete;
		HttpSession session = request.getSession();
		
		pizzaService = new PizzaServiceImpl();
		pizzasizes = pizzaService.getPizzaSizes();
		pizzaService.convertPizzaSizes(pizzasizes);
		session.setAttribute("pizzasizeshash", pizzasizes);
		
		// Load the element of our pizza, like different types of 
		// crust, sauce, cheese, etc. No complete pizzas here, though.
		pizzaelements = pizzaService.getPizzaElements(2);
		session.setAttribute("pizzaelements", pizzaelements);
		
		// Load the complete pizzas here.
		pizzacomplete = pizzaService.getPizzaElements(3);
		session.setAttribute("pizzacomplete", pizzacomplete);
		
		// If a pizza id is incoming from form, load that pizza
		// from session so it can be edited.
		if (request.getParameterMap().containsKey("pizzaid") && 
				!((String) request.getParameter("pizzaid")).isEmpty()) {
			System.out.println("Inside if");
			PizzaImpl pizza = (PizzaImpl) session.getAttribute((String) request.getParameter("pizzaid"));
			request.setAttribute("pizza", pizza);
			System.out.println("Here is pizza: " + pizza);
			System.out.println("Here is pizzaid: " + request.getParameter("pizzaid"));
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
