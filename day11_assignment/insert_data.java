//public static void main(String[] args) throws ClassNotFoundException , SQLException
//	{
//		//import packages
//		//create object for connection
//		//Retrieve data
//		//close connection
//		String url="jdbc:mysql://localhost:3306/mydb";
//		String user="root";
//		String password="root";
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		
//		 try {
//		            Connection conn = DriverManager.getConnection(url, user, password);
//		            Statement stmt = conn.createStatement();
//		         
//		            // 1. Create table
//		            stmt.execute("CREATE TABLE IF NOT EXISTS Student ("
//		                    + "id INT, "
//		                    + "name CHAR(20), "
//		                    + "city VARCHAR(50), "
//		                    + "percentage DOUBLE)");
//
//		            stmt.execute("CREATE TABLE IF NOT EXISTS Institute ("
//		                    + "institute_id INT, "
//		                    + "name VARCHAR(50), "
//		                    + "city VARCHAR(50))");
//
//		            // 2.Inserting records
//		            stmt.execute("INSERT INTO Student VALUES (1, 'Arya', 'Hyderbad', 80)");
//		            stmt.execute("INSERT INTO Student VALUES (2, 'Bharath', 'Vijayawada', 90)");
//		            stmt.execute("INSERT INTO Student VALUES (3, 'Chethan', 'Vizag', 75)");
//		            stmt.execute("INSERT INTO Student VALUES (4, 'Dhruv', 'Hyderbad', 95)");
//		            stmt.execute("INSERT INTO Student VALUES (5, 'Ekaanth', 'Vizag', 95)");
//
//		            stmt.execute("INSERT INTO Institute VALUES (1, 'ABC Institute', 'Hyderbad')");
//		            stmt.execute("INSERT INTO Institute VALUES (2, 'XYZ Institute', 'Vizag')");
//
//		            // 3.Printing tables
//		            ResultSet rs = stmt.executeQuery("SELECT * FROM Student");
//		            System.out.println("Student Table:");
//		            while (rs.next()) 
//		            {
//		            	int id=rs.getInt("id");
//						String name=rs.getString("name");
//						String city=rs.getString("city");
//						int per=rs.getInt("per");
//						System.out.println(id+"  |  "+ name+"  |  "+city+"   |   "+per);
//		            }
//		            rs.close();
//		            ResultSet rs1 = stmt.executeQuery("SELECT * FROM Institute");
//		            System.out.println("Institute Table:");
//		            while (rs1.next()) 
//		            {
//
//		            	int id=rs1.getInt("id");
//						String name=rs1.getString("name");
//						String city=rs1.getString("city");
//						System.out.println(id+"  |  "+ name+"  |  "+city);
//		                
//		            }
//                    rs1.close();
//		            // 4.Update table
//		            stmt.execute("UPDATE Student SET percentage = 83 WHERE id = 1");
//		            stmt.execute("UPDATE Student SET percentage = 85 WHERE id = 3");
//		            
//
//		            //5.Highest percentage student
//		            rs = stmt.executeQuery("SELECT * FROM Student ORDER BY percentage DESC LIMIT 1");
//		            System.out.println("\nHighest Percentage Student:");
//		            if (rs.next()) 
//		            {
//		                System.out.println(rs.getString("name") + " - " + rs.getDouble("percentage"));
//		            }
//                    rs.close();
//		            // 6.Arrange in ascending order
//		            rs = stmt.executeQuery("SELECT * FROM Student ORDER BY name ASC");
//		            System.out.println("\nStudents in Ascending Order by Name:");
//		            while (rs.next())
//		            {
//		                System.out.println(rs.getString("name"));
//		            }
//                    rs.close();
//		            // 7. Same city students
//		            rs = stmt.executeQuery(
//		                    "SELECT city FROM Student GROUP BY city HAVING COUNT(*) > 1");
//		            System.out.println("\nCities with Multiple Students:");
//		            while (rs.next()) 
//		            {
//		                System.out.println(rs.getString("city"));
//		            }
//                    rs.close();
//		            // 8. Add new column
//		            stmt.execute("ALTER TABLE Student ADD COLUMN age INT");
//
//		            // 9. Modify column datatype
//		            stmt.execute("ALTER TABLE Student MODIFY COLUMN name VARCHAR(50)");
//
//		            // 10. Change table name
//		            stmt.execute("RENAME TABLE Student TO StudentInfo");
//
//		            // 11. Delete column
//		            stmt.execute("ALTER TABLE StudentInfo DROP COLUMN age");
//
//		            // 12. Delete single row
//		            stmt.execute("DELETE FROM StudentInfo WHERE id = 1");
//
//		            // 13. Delete all records without deleting table
//		            stmt.execute("TRUNCATE TABLE StudentInfo");
//
//		            // 14. Delete entire table
//		            stmt.execute("DROP TABLE IF EXISTS StudentInfo");
//
//		            // Recreate tables for joins
//		            stmt.execute("CREATE TABLE Student (id INT PRIMARY KEY, name VARCHAR(50), city VARCHAR(50))");
//		            stmt.execute("INSERT INTO Student VALUES (1, 'Arya', 'Hyderbad'), (2, 'Bharath', 'Vijayawada'),(3, 'Chethan', 'Vizag'),(4, 'Dhruv', 'Hyderbad'),(5, 'Ekaanth', 'Vizag')");
//
//		            stmt.execute("CREATE TABLE Institute (institute_id INT PRIMARY KEY, name VARCHAR(50), city VARCHAR(50))");
//		            stmt.execute("INSERT INTO Institute VALUES (1, 'ABC Institute', 'Hyderbad'), (2, 'XYZ Institute', 'Vizag')");
//
//		            // 15. INNER JOIN (common records)
//		            rs = stmt.executeQuery("SELECT * FROM Student s INNER JOIN Institute i ON s.city = i.city");
//		            System.out.println("\nInner Join (Common Records):");
//		            while (rs.next()) 
//		            {
//		                System.out.println(rs.getString("s.name") + " - " + rs.getString("i.name"));
//		            }
//                    rs.close();
//		            // 16. LEFT JOIN
//		            rs = stmt.executeQuery("SELECT * FROM Student as s LEFT JOIN Institute as i ON s.city = i.city");
//		            System.out.println("\nLeft Join:");
//		            while (rs.next()) 
//		            {
//		                System.out.println(rs.getString("s.name") + " - " + rs.getString("i.name"));
//		            }
//                    rs.close();
//		            // 17. RIGHT JOIN
//		            rs = stmt.executeQuery("SELECT * FROM Student as s RIGHT JOIN Institute as i ON s.city = i.city");
//		            System.out.println("\nRight Join:");
//		            while (rs.next())
//		            {
//		                System.out.println(rs.getString("s.name") + " - " + rs.getString("i.name"));
//		            }
//                    rs.close();
//		            // 18. FULL OUTER JOIN (using UNION)
//		            rs = stmt.executeQuery(
//		                "(SELECT * FROM Student as s LEFT JOIN Institute as i ON s.city = i.city) " +
//		                "UNION " +
//		                "(SELECT * FROM Student as s RIGHT JOIN Institute as i ON s.city = i.city)"
//		            );
//		            System.out.println("\nFull Outer Join:");
//		            while (rs.next()) 
//		            {
//		                System.out.println(rs.getString("s.name") + " - " + rs.getString("i.name"));
//		            }
//		            stmt.close();
//		            conn.close();           
//              
//		  } 
//		 catch (SQLException e) 
//		 {
//		    e.printStackTrace();
//		 }
//		 catch (Exception e) 
//		 {
//			 System.out.println(e);
//		 }
//	}
//}
package day11_assignment;

