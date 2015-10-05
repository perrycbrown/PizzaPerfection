package com.jwad.pizzaperfection.webservlet;
import javax.servlet.*;
import javax.servlet.http.*;

import com.jwad.pizzaperfection.domainmodel.PizzaImpl;
import com.jwad.pizzaperfection.service.PizzaServiceImpl;
import com.jwad.pizzaperfection.utility.PizzaUtility;

import java.io.*;
import java.util.ArrayList;
 
@SuppressWarnings("serial")
public class ReviewOrderServlet extends HttpServlet {
 
    public void doGet(HttpServletRequest request,HttpServletResponse response)
                                         throws ServletException, IOException {
        doPost(request, response);
    }
 
    public void doPost(HttpServletRequest request,HttpServletResponse response)
                                        throws ServletException, IOException {
    	
    	// From session, get all the pizzas ordered:
    	ArrayList<PizzaImpl> AllPizzas = PizzaUtility.getAllPizzasFromSession(request);
    	
    	System.out.println("Here is all pizzas: " + AllPizzas);
 
    	request.setAttribute("allpizzas", AllPizzas);
       	getServletContext().getRequestDispatcher("/WEB-INF/ReviewOrder.jsp").forward(request, response);
    	
    }
 
}
