package com.log.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class LoginDao {

	String sql = "select * from registration where uname=? and acc=?";
	String url = "jdbc:mysql://localhost:3306/bank";
	String username ="root";
	String password ="1234";
	public boolean check(String uname ,String  acc) 
	{
        try	{
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection con = DriverManager.getConnection(url,username,password);
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, uname);
            st.setString(2, acc);
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
            	return true;
            }
        } catch(Exception e)
        {
        	e.printStackTrace();
        }
		return false;
	
}
	}

