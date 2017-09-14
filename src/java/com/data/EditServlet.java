/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aniket
 */
@WebServlet(name = "EditServlet", urlPatterns = {"/EditServlet"})
public class EditServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Contact</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
          
        Contact e=ContactDao.getAddById(id); 
        out.print("<body bgcolor=#F2F2F2>");  
        out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
        out.print("<tr><td>Lname:</td><td><input type='text' name='lname' value='"+e.getLname()+"'/></td></tr>");  
        out.print("<tr><td>Fname:</td><td><input type='text' name='fname' value='"+e.getFname()+"'/></td></tr>");  
        out.print("<tr><td>Address:</td><td><input type='text' name='address' value='"+e.getAddress()+"'/></td></tr>");  
        out.print("<tr><td>Phone:</td><td><input type='text' name='phone' value='"+e.getPhone()+"'/></td></tr>");  
        out.print("<tr><td>Birthday:</td><td><input type='text' name='birthday' value='"+e.getBirthday()+"'/></td></tr>");  
        out.print("<tr><td>Datecreated:</td><td><input type='text' name='datecreated' value='"+e.getDatecreated()+"'/></td></tr>");  

        out.print("<tr><td colspan='2' ><input type='submit' value='Save'  /></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }  
}  

 
