package com.jwad.pizzaperfection.webservlet;
import javax.servlet.*;
import javax.servlet.http.*;

import com.jwad.pizzaperfection.utility.PizzaUtility;

import java.io.*;
 
@SuppressWarnings("serial")
public class DeleteServlet extends HttpServlet {
 
    public void doGet(HttpServletRequest request,HttpServletResponse response)
                                         throws ServletException, IOException {
        doPost(request, response);
    }
 
    public void doPost(HttpServletRequest request,HttpServletResponse response)
                                        throws ServletException, IOException {
    	
    	if (request.getParameterMap().containsKey("pizzaid") && 
				!((String) request.getParameter("pizzaid")).isEmpty()) {
    		PizzaUtility.deletePizzaFromSession(request.getParameter("pizzaid"), request);
    	}    	
 
    	response.sendRedirect("../revieworder/");
       	//getServletContext().getRequestDispatcher("com.jwad.pizzaperfection.webservlet.ReviewOrderServlet").forward(request, response);
    	
    }
 
}
