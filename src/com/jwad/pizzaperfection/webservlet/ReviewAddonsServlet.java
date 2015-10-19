package com.jwad.pizzaperfection.webservlet;
import javax.servlet.*;
import javax.servlet.http.*;

import com.jwad.pizzaperfection.domainmodel.PizzaAddonsImpl;
import com.jwad.pizzaperfection.service.PizzaAddonsServiceImpl;
import com.jwad.pizzaperfection.utility.PizzaUtility;

import java.io.*;
import java.util.ArrayList;
 
@SuppressWarnings("serial")
public class ReviewAddonsServlet extends HttpServlet {
 
    public void doGet(HttpServletRequest request,HttpServletResponse response)
                                         throws ServletException, IOException {
        doPost(request, response);
    }
 
    public void doPost(HttpServletRequest request,HttpServletResponse response)
                                        throws ServletException, IOException {
    	
    	PizzaAddonsServiceImpl pizzaAddonsService = new PizzaAddonsServiceImpl();
    	HttpSession session = request.getSession();
    	
    	// Gather incoming pizza addons info into an ArrayList of PizzaAddonsImpl objects, 
    	// and calculate total price also:
    	ArrayList<PizzaAddonsImpl> pizzaAddons = pizzaAddonsService.createPizzaAddonsFromRequest(request);
    	request.setAttribute("pizzaaddons", pizzaAddons);
    	Double total = pizzaAddonsService.getTotalPrice(pizzaAddons);
    	request.setAttribute("total",String.format("%1$,.2f", total));
     	 
    	//Update session:
    	if (request.getParameterMap().containsKey("addonsid") && 
				!((String) request.getParameter("addonsid")).isEmpty()) {
    		PizzaUtility.updatePizzaAddonsInSession(request.getParameter("addonsid"), pizzaAddons, request);
    		request.setAttribute("addonsid", request.getParameter("addonsid"));
    		session.setAttribute("addonsid", request.getParameter("addonsid"));
    	}
    	else {
    		String pizzaAddonsId = PizzaUtility.writePizzaAddonsToSession(pizzaAddons, request);
    		request.setAttribute("addonsid", pizzaAddonsId);
    		session.setAttribute("addonsid", pizzaAddonsId);
    	}
    	
       	getServletContext().getRequestDispatcher("/WEB-INF/ReviewAddons.jsp").forward(request, response);
    	
    }
 
}
