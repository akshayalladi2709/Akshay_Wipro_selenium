package day11_assignment;

import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;

public class Jdbc_conn {
		public static void main(String []args) throws ClassNotFoundException, SQLException
		{
			String url="jdbc:mysql://localhost:3306/mydb";
			String user="root";
			String password="1234";
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			Connection con=DriverManager.getConnection(url,user,password);
			System.out.println("Connection created");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from emp");
			System.out.println("ID\t name\t salary\t");
			while(rs.next())
			{
				int id=rs.getInt("id");
				String st=rs.getString("name");
				System.out.println("ID:"+id+"\t"+"Name:"+st+"\t");
			}
			rs.close();
			stmt.close();
			con.close();
		}
}
