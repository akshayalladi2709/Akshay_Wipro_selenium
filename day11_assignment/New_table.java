package day11_assignment;

import java.sql.*;

public class New_table {
    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        
        String url = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String password = "1234";

        // String to create the table (uncomment if running for the first time)
        String createTableSQL = "CREATE TABLE IF NOT EXISTS stud ("
                + "rollno INT PRIMARY KEY, "
                + "name VARCHAR(50), "
                + "per INT, "
                + "email VARCHAR(50))";

        // String to insert values
//        String[] inserts = {
//        	    "INSERT INTO stud VALUES (102, 'Suhas', 95, 'suhas@mail.com')",
//        	    "INSERT INTO stud VALUES (103, 'Uday', 88, 'uday@mail.com')",
//        	    "INSERT INTO stud VALUES (104, 'Meena', 91, 'meena@mail.com')",
//        	    "INSERT INTO stud VALUES (105, 'Ravi', 85, 'ravi@mail.com')"
//        	};
       String update="update stud set per=97 where rollno=102 ";
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create connection
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connection created");

            // Create statement
            Statement st = con.createStatement();

            // Create table if it doesn't exist
            st.executeUpdate(createTableSQL);
            st.executeUpdate(update);
            System.out.println("Table 'stud' ready");

            // Insert values
//            for (String query : inserts) {
//                int rows = st.executeUpdate(query);
//                if (rows > 0) {
//                    System.out.println("✅ Inserted: " + query);
//                }
//            }

            // Display all records
            ResultSet rs = st.executeQuery("SELECT * FROM stud");

            System.out.println("RollNo\tName\tPercentage\tEmail");
            while (rs.next()) {
                int roll = rs.getInt("rollno");
                String name = rs.getString("name");
                int per = rs.getInt("per");
                String email = rs.getString("email");

                System.out.println(roll + "\t" + name + "\t" + per + "\t" + email);
            }

            // Close all
            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {
            System.out.println(" Error: " + e);
        }
    }
}
