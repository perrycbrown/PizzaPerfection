package com.jwad.pizzaperfection.webservlet;
import javax.servlet.*;
import javax.servlet.http.*;

import com.jwad.pizzaperfection.domainmodel.PizzaImpl;
import com.jwad.pizzaperfection.service.PizzaServiceImpl;

import java.io.*;
import java.util.HashMap;
 
 
@SuppressWarnings("serial")
public class PaymentServlet extends HttpServlet {
 
    public void doGet(HttpServletRequest request,HttpServletResponse response)
                                         throws ServletException, IOException {
        doPost(request, response);
    }
 
    public void doPost(HttpServletRequest request,HttpServletResponse response)
                                        throws ServletException, IOException {
 
    	//Write to a session:
    	HttpSession session = request.getSession();
    	PizzaImpl pizza = (PizzaImpl) session.getAttribute("pizza");
    	
       	request.setAttribute("pizza",pizza);
    	request.getRequestDispatcher("/Payment.jsp").forward(request, response);
    	
    }
     
    
}
