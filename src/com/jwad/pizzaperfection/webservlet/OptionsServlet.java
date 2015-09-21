package com.jwad.pizzaperfection.webservlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.HashMap;
 
 
@SuppressWarnings("serial")
public class OptionsServlet extends HttpServlet {
 
    public void doGet(HttpServletRequest request,HttpServletResponse response)
                                         throws ServletException, IOException {
        doPost(request, response);
    }
 
    public void doPost(HttpServletRequest request,HttpServletResponse response)
                                        throws ServletException, IOException {
         
    	request.getRequestDispatcher("/Options.jsp").forward(request, response);
    	
    }
     
    
}
