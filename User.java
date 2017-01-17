package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {

	String uname,pass,role;
	public User(String uname,String pass,String role) {
		this.uname=uname;
		this.pass=pass;
		this.role=role;
		
	}
	public int login(){
		try{
			
			Connection con=DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			Statement stmt=con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from login where username='"+uname+"'");
			while(rs.next())
			{
				String s1=rs.getString(1);
				String s2=rs.getString(2);
				if(pass.equals(s2))
				{
					if(uname.equals(s1) && role.equals("Admin"))
					{
						return 1;
					}
					else if(uname.equals(s1) && role.equals("Operator"))
					{
						return 2;
					}
				}
			}
			con.close();
		}
		catch(Exception e){ 
			System.out.println(e);
			
		}
		return 0;
	}
}



