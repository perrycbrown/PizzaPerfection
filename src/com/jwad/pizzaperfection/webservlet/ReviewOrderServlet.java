package com.jwad.pizzaperfection.webservlet;
import javax.servlet.*;
import javax.servlet.http.*;

import com.jwad.pizzaperfection.domainmodel.PizzaImpl;
import com.jwad.pizzaperfection.service.PizzaServiceImpl;
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
    	
    	// From session, get all the pizzas ordered:
    	HashMap<String,PizzaImpl> AllPizzas = PizzaUtility.getAllPizzasFromSession(request);
    	
    	// Also get the total price of all pizzas:
    	double grandTotal = PizzaUtility.totalAllPizzasFromSession(request);
 
    	request.setAttribute("allpizzas", AllPizzas);
    	request.setAttribute("grandtotal", grandTotal);
       	getServletContext().getRequestDispatcher("/WEB-INF/ReviewOrder.jsp").forward(request, response);
    	
    }
 
}
