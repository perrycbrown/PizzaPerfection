package com.jwad.pizzaperfection.webservlet;
import javax.servlet.*;
import javax.servlet.http.*;

import com.jwad.pizzaperfection.domainmodel.PizzaAddonsImpl;
import com.jwad.pizzaperfection.domainmodel.PizzaImpl;
import com.jwad.pizzaperfection.service.PizzaAddonsServiceImpl;
import com.jwad.pizzaperfection.utility.PizzaUtility;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
 
@SuppressWarnings("serial")
public class ReviewOrderServlet extends HttpServlet {
 
    public void doGet(HttpServletRequest request,HttpServletResponse response)
                                         throws ServletException, IOException {
        doPost(request, response);
    }
 
    public void doPost(HttpServletRequest request,HttpServletResponse response)
                                        throws ServletException, IOException {
    	
    	double grandTotalAddons = 0;
    	ArrayList<PizzaAddonsImpl> PizzaAddons = new ArrayList<PizzaAddonsImpl>();
    	PizzaAddonsServiceImpl pizzaAddonsService = new PizzaAddonsServiceImpl();
    	
    	// From session, get all the pizzas ordered:
    	HashMap<String,PizzaImpl> AllPizzas = PizzaUtility.getAllPizzasFromSession(request);
    	
    	// Also get the total price of all pizzas:
    	double grandTotalPizzas = PizzaUtility.totalAllPizzasFromSession(request);
    	
    	// From session, get all addons ordered:
    	//HashMap<String, PizzaAddonsImpl> AllPizzaAddons = PizzaUtility.getAllPizzaAddonsFromSession(request);
    	HttpSession session = request.getSession();
		PizzaAddons = PizzaUtility.getPizzaAddonsFromSession((String) session.getAttribute("addonsid"), request);
    	// Also get the total price of all addons:
		if (PizzaAddons != null) {
			grandTotalAddons = pizzaAddonsService.getTotalPrice(PizzaAddons);
		}
    	
    	double grandTotal = grandTotalPizzas + grandTotalAddons;
 
    	request.setAttribute("allpizzas", AllPizzas);
    	request.setAttribute("alladdons", PizzaAddons);
		request.setAttribute("grandTotalAddons", grandTotalAddons);
    	request.setAttribute("grandtotal", grandTotal);
       	getServletContext().getRequestDispatcher("/WEB-INF/ReviewOrder.jsp").forward(request, response);
    	
    }
 
}
