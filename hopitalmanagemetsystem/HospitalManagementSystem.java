package hopitalmanagemetsystem;
import java.sql.*;
import java.util.Scanner;

public class HospitalManagementSystem {
    private static Connection connection;
    private static DTA_hms dao;

    public static void main(String[] args) {
        try {
            // Establish database connection
           connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hms", "root", "");
            dao = new DTA_hms(connection);
            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n--- Hospital Management System ---");
                System.out.println("1. Add Patient");
                System.out.println("2. Update Patient");
                System.out.println("3. Delete Patient");
                System.out.println("4. Search Patient");
                System.out.println("5. View All Patients");
                System.out.println("6. Add Doctor");
                System.out.println("7. Update Doctor");
                System.out.println("8. Delete Doctor");
                System.out.println("9. Search Doctor");
                System.out.println("10. View All Doctors");
                System.out.println("11. Add Appointment");
                System.out.println("12. Delete Appointment");
                System.out.println("13. Add Bill");
                System.out.println("14. View All Bills");
                System.out.println("15. Doctor Wise Patient Report");
                System.out.println("16. Date Wise Bill Report");
                System.out.println("17. Patient Wise Bill Report");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();  // consume newline

                switch (choice) {
                    case 1:
                        addPatient(scanner);
                        break;
                    case 2:
                        updatePatient(scanner);
                        break;
                    case 3:
                        deletePatient(scanner);
                        break;
                    case 4:
                        searchPatient(scanner);
                        break;
                    case 5:
                        dao.viewAllPatients();
                        break;
                    case 6:
                        addDoctor(scanner);
                        break;
                    case 7:
                        updateDoctor(scanner);
                        break;
                    case 8:
                        deleteDoctor(scanner);
                        break;
                    case 9:
                        searchDoctor(scanner);
                        break;
                    case 10:
                        dao.viewAllDoctors();
                        break;
                    case 11:
                        addAppointment(scanner);
                        break;
                    case 12:
                        deleteAppointment(scanner);
                        break;
                    case 13:
                        addBill(scanner);
                        break;
                    case 14:
                        dao.viewAllBills();
                        break;
                    case 15:
                        dao.doctorWisePatientReport();
                        break;
                    case 16:
                        dateWiseBillReport(scanner);
                        break;
                    case 17:
                        patientWiseBillReport(scanner);
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } while (choice != 0);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void addPatient(Scanner scanner) {
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Patient Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // consume newline
        System.out.print("Enter Patient Disease: ");
        String disease = scanner.nextLine();
        System.out.print("Enter Patient Phone Number: ");
        String phone_number = scanner.nextLine();
        
        try {
            dao.addPatient(name, age, disease, phone_number);
            System.out.println("Patient added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updatePatient(Scanner scanner) {
        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // consume newline
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Patient Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // consume newline
        System.out.print("Enter Patient Disease: ");
        String disease = scanner.nextLine();
        System.out.print("Enter Patient Phone Number: ");
        String phone_number = scanner.nextLine();
        
        try {
            dao.updatePatient(id, name, age, disease, phone_number);
            System.out.println("Patient updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deletePatient(Scanner scanner) {
        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        
        try {
            dao.deletePatient(id);
            System.out.println("Patient deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void searchPatient(Scanner scanner) {
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        
        try {
            Patient patient = dao.searchPatient(name);
            if (patient != null) {
                System.out.println("Found Patient: " + patient);
            } else {
                System.out.println("Patient not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addDoctor(Scanner scanner) {
        System.out.print("Enter Doctor Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Qualification: ");
        String qualification = scanner.nextLine();
        System.out.print("Enter Designation: ");
        String designation = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();  // consume newline
        System.out.print("Enter Department: ");
        String department = scanner.nextLine();
        
        try {
            dao.addDoctor(name, qualification, designation, salary, department);
            System.out.println("Doctor added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateDoctor(Scanner scanner) {
        System.out.print("Enter Doctor ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // consume newline
        System.out.print("Enter Doctor Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Qualification: ");
        String qualification = scanner.nextLine();
        System.out.print("Enter Designation: ");
        String designation = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();  // consume newline
        System.out.print("Enter Department: ");
        String department = scanner.nextLine();
        
        try {
            dao.updateDoctor(id, name, qualification, designation, salary, department);
            System.out.println("Doctor updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteDoctor(Scanner scanner) {
        System.out.print("Enter Doctor ID: ");
        int id = scanner.nextInt();
        
        try {
            dao.deleteDoctor(id);
            System.out.println("Doctor deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void searchDoctor(Scanner scanner) {
        System.out.print("Enter Doctor Name: ");
        String name = scanner.nextLine();
        
        try {
            Doctor doctor = dao.searchDoctor(name);
            if (doctor != null) {
                System.out.println("Found Doctor: " + doctor);
            } else {
                System.out.println("Doctor not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addAppointment(Scanner scanner) {
        System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
        String dateStr = scanner.nextLine();
        System.out.print("Enter Appointment Time (HH:MM:SS): ");
        String timeStr = scanner.nextLine();
        System.out.print("Enter Appointment Type: ");
        String type = scanner.nextLine();
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        System.out.print("Enter Doctor ID: ");
        int doctorId = scanner.nextInt();
        
        try {
            Date date = Date.valueOf(dateStr);
            Time time = Time.valueOf(timeStr);
            dao.addAppointment(date, time, type, patientId, doctorId);
            System.out.println("Appointment added successfully.");
        } catch (SQLException | IllegalArgumentException e) {
        }
    }

    private static void deleteAppointment(Scanner scanner) {
        System.out.print("Enter Appointment ID: ");
        int id = scanner.nextInt();
        
        try {
            dao.deleteAppointment(id);
            System.out.println("Appointment deleted successfully.");
        } catch (SQLException e) {
        }
    }

    private static void addBill(Scanner scanner) {
        System.out.print("Enter Bill Date (YYYY-MM-DD): ");
        String dateStr = scanner.nextLine();
        System.out.print("Enter Bill Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // consume newline
        System.out.print("Enter Payer Name: ");
        String payer = scanner.nextLine();
        System.out.print("Enter Appointment ID: ");
        int appointmentId = scanner.nextInt();
        
        try {
            Date date = Date.valueOf(dateStr);
            dao.addBill(date, amount, payer, appointmentId);
            System.out.println("Bill added successfully.");
        } catch (SQLException | IllegalArgumentException e) {
        }
    }

    private static void dateWiseBillReport(Scanner scanner) {
        System.out.print("Enter Date (YYYY-MM-DD): ");
        String dateStr = scanner.nextLine();
        
        try {
            Date date = Date.valueOf(dateStr);
            dao.dateWiseBillReport(date);
        } catch (SQLException | IllegalArgumentException e) {
        }
    }

    private static void patientWiseBillReport(Scanner scanner) {
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        
        try {
            dao.patientWiseBillReport(patientId);
        } catch (SQLException e) {
        }
    }
}