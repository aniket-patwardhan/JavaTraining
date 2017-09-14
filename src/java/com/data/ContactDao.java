/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data;
import java.util.*;  
import java.sql.*; 
/**
 *
 * @author Aniket
 */
public class ContactDao {
     
  

  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","root");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(Contact e){  
        int status=0;  
        try{  
            Connection con=ContactDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into addressbook(lname,fname,address,phone,birthday,datecreated) values (?,?,?,?,?,?,?)");  
            ps.setString(1,e.getLname());  
            ps.setString(2,e.getFname());  
            ps.setString(3,e.getAddress());  
            ps.setString(4,e.getPhone());  
            ps.setString(5,e.getBirthday());
            ps.setString(6,e.getDatecreated());
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Contact e){  
        int status=0;  
        try{  
            Connection con=ContactDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update addressbook set lname=?,fname=?,address=?,phone=?,birthday=?,datecreated=? where id=?");  
            ps.setString(1,e.getLname());  
            ps.setString(2,e.getFname());  
            ps.setString(3,e.getAddress());  
            ps.setString(4,e.getPhone());  
            ps.setString(5,e.getBirthday()); 
            ps.setString(6,e.getDatecreated()); 
            ps.setInt(7,e.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=ContactDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from addressbook where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Contact getAddById(int id){  
        Contact e=new Contact();  
          
        try{  
            Connection con=ContactDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from addressbook where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setLname(rs.getString(2));  
                e.setFname(rs.getString(3));  
                e.setAddress(rs.getString(4));  
                e.setPhone(rs.getString(5));
                e.setBirthday(rs.getString(6));
                e.setDatecreated(rs.getString(7));
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Contact> getAllContacts(){  
        List<Contact> list=new ArrayList<Contact>();  
          
        try{  
            Connection con=ContactDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from addressbook");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Contact e=new Contact();  
                e.setId(rs.getInt(1));  
                e.setLname(rs.getString(2));  
                e.setFname(rs.getString(3));  
                e.setAddress(rs.getString(4));  
                e.setPhone(rs.getString(5));  
                 e.setBirthday(rs.getString(6)); 
                  e.setDatecreated(rs.getString(7)); 
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}  
    

