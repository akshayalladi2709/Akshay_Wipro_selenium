package day11_assignment;

import java.sql.*;
import java.util.ArrayList;
class Course {
    int id;
    String name;
  Course(int id, String name) {
    this.id = id;
    this.name = name;
    }
}
public class Prepared {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String password = "1234";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, password);
        ArrayList<Course> courseList = new ArrayList<>();
        courseList.add(new Course(101, "C"));
        courseList.add(new Course(102, "B"));
        courseList.add(new Course(103, "A"));
        courseList.add(new Course(104, "E"));
        courseList.add(new Course(105, "F"));
        int i = 1;
        for (Course c : courseList) {
            String query = "INSERT INTO courses (course_id, course_name) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, c.id);
            ps.setString(2, c.name);
            ps.executeUpdate();
            System.out.println("Inserted row " + i);
            i++;
            ps.close();
        }
        
        System.out.println("\nData in courses table:");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM courses");
        while (rs.next()) {
            int id = rs.getInt("course_id");
            String name = rs.getString("course_name");
            System.out.println(id + " - " + name);
        }
        rs.close();
        st.close();
        con.close();
    }
}
