package hosipatel;

import java.util.Scanner; 



public class Main { 

    public static void main(String[] args) { 

        Scanner sc = new Scanner(System.in); 

        System.out.print("👤 Username: "); 

        String username = sc.nextLine(); 

        System.out.print("🔒 Password: "); 

        String password = sc.nextLine(); 

 

        if (!LoginService.login(username, password)) { 

            System.out.println("❌ Login failed. Exiting..."); 

            return; 

        } 

 

        while (true) { 

            System.out.println("\n🏥 Hospital Management Menu"); 

            System.out.println("1. Register Patient"); 

            System.out.println("2. View Patients"); 

            System.out.println("3. Book Appointment"); 

            System.out.println("4. Generate Billing"); 

            System.out.println("5. Exit"); 

            System.out.print("Choose option: "); 

            int choice = sc.nextInt(); 

 

            switch (choice) { 

                case 1 -> PatientService.registerPatient(sc); 

                case 2 -> PatientService.viewPatients(); 

                case 3 -> AppointmentService.bookAppointment(sc); 

                case 4 -> BillingService.generateBill(sc); 

                case 5 -> { 

                    System.out.println("🔚 Goodbye!"); 

                    return; 

                } 

                default -> System.out.println("❓ Invalid option"); 

            } 

        } 

    } 

} 
