/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data;
  
import java.util.List;  
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
@WebServlet(name = "ViewServlet", urlPatterns = {"/ViewServlet"})
public class ViewServlet extends HttpServlet {

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
        out.println("<body bgcolor=\"#F2F2F2\" >");
          
        out.println("<h1>Contact List</h1>");  
          
        List<Contact> list=ContactDao.getAllContacts();  
         
        out.print("<table border='1' width='70%'");  
        out.print("<tr><th>Id</th><th>Lname</th><th>Fname</th><th>Address(City with zipcode)</th><th>Phone</th><th>Birthday</th><th>Datecreated</th><th>Edit</th><th>Delete</th></tr>");  
        for(Contact e:list){  
        out.print("<tr><td>"+e.getId()+"</td><td>"+e.getLname()+"</td><td>"+e.getFname()+"</td><td>"+e.getAddress()+"</td><td>"+e.getPhone()+"</td><td>"+e.getBirthday()+"</td><td>"+e.getDatecreated()+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>"); 
         out.print("</br>");
         out.print("</br>");
        out.println("<a href='index.html'>Add New Contact</a>");
          
        out.close();  
    }  
}  
