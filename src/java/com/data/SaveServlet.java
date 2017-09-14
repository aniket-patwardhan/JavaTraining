/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data;

import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aniket
 */
public class SaveServlet extends HttpServlet {

    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
    
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String lname=request.getParameter("lname");  
        String fname=request.getParameter("fname");  
        String address=request.getParameter("address");  
        
        
         String phone=request.getParameter("phone"); 
         String birthday=request.getParameter("birthday");
         
        String datecreated = request.getParameter("datecreated");
          
        Contact e=new Contact();  
        e.setLname(lname);  
        e.setFname(fname);  
        e.setAddress(address);  
        e.setPhone(phone);  
        e.setBirthday(birthday);
        e.setDatecreated(datecreated);
        
          
        int status=ContactDao.save(e);  
        if(status>0){  
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("index.html").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
            out.println("<body bgcolor=#F2F2F2");
        }  
       
        out.close();  
    }  
  
}  
