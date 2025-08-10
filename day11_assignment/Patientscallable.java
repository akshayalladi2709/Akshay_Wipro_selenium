package day11_assignment;

import java.sql.*;

public class Patientscallable{
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";  // Change DB name if needed
        String user = "root";
        String password = "1234";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            // 1. Call avg_patient_count
            System.out.println("---- Average Patient Count Per Day ----");
            CallableStatement cs1 = conn.prepareCall("{CALL avg_patient_count()}");
            ResultSet rs1 = cs1.executeQuery();
            while (rs1.next()) {
                System.out.println("Average: " + rs1.getDouble("avg_patients_per_day"));
            }
            rs1.close();
            cs1.close();

            // 2. Call patients_same_ward
            System.out.println("\n---- Patients in Same Ward ----");
            CallableStatement cs2 = conn.prepareCall("{CALL patients_same_ward()}");
            ResultSet rs2 = cs2.executeQuery();
            while (rs2.next()) {
                System.out.println("ID: " + rs2.getInt("patient_id") + 
                                   ", Name: " + rs2.getString("name") +
                                   ", Ward: " + rs2.getString("ward") +
                                   ", Admission: " + rs2.getDate("admission_date"));
            }
            rs2.close();
            cs2.close();

            // 3. Call sort_by_admission
            System.out.println("\n---- Patients Sorted by Admission Date ----");
            CallableStatement cs3 = conn.prepareCall("{CALL sort_by_admission()}");
            ResultSet rs3 = cs3.executeQuery();
            while (rs3.next()) {
                System.out.println("ID: " + rs3.getInt("patient_id") +
                                   ", Name: " + rs3.getString("name") +
                                   ", Ward: " + rs3.getString("ward") +
                                   ", Admission: " + rs3.getDate("admission_date"));
            }
            rs3.close();
            cs3.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

