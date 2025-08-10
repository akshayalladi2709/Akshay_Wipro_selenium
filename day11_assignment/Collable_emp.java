package day11_assignment;

import java.sql.*;

public class Collable_emp {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "1234";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            CallableStatement stmt = conn.prepareCall("{CALL update_employee_and_report()}");

            boolean hasResults = stmt.execute();
            int resultSetCount = 1;

            while (hasResults) {
                ResultSet rs = stmt.getResultSet();

                if (resultSetCount == 1) {
                    System.out.println("\n--- Duplicate Names (name_count > 1) ---");
                    System.out.println("Name\t\tCount");
                    while (rs.next()) {
                        String name = rs.getString("name");
                        int count = rs.getInt("name_count");
                        System.out.println(name + "\t\t" + count);
                    }
                } else if (resultSetCount == 2) {
                    System.out.println("\n--- Highest and Lowest Salaries ---");
                    if (rs.next()) {
                        double highest = rs.getDouble("highest_salary");
                        double lowest = rs.getDouble("lowest_salary");
                        System.out.println("Highest Salary: " + highest);
                        System.out.println("Lowest Salary: " + lowest);
                    }
                }

                rs.close();
                hasResults = stmt.getMoreResults();
                resultSetCount++;
            }

            stmt.close();

            // 🔁 Now show the final updated employee table (to show bonus effect)
            Statement st = conn.createStatement();
            ResultSet rsFinal = st.executeQuery("SELECT * FROM employee");

            System.out.println("\n--- Updated Employee Table (after 5000 bonus) ---");
            System.out.println("ID\tName\t\tSalary");
            while (rsFinal.next()) {
                int id = rsFinal.getInt("id");
                String name = rsFinal.getString("name");
                double salary = rsFinal.getDouble("salary");
                System.out.println(id + "\t" + name + "\t\t" + salary);
            }

            rsFinal.close();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
