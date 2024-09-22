package hopitalmanagemetsystem;
import java.sql.*;

public interface DAO_hms {
    void addPatient(String p_name, int p_age, String p_disease, String p_phone_number) throws SQLException;
    void updatePatient(int p_id, String p_name, int p_age, String p_disease, String p_phone_number) throws SQLException;
    void deletePatient(int p_id) throws SQLException;
    Patient searchPatient(String p_name) throws SQLException;
    void viewAllPatients() throws SQLException;

    void addDoctor(String d_name, String d_qualification, String d_designation, 
                   double d_salary, String d_department) throws SQLException;
    void updateDoctor(int d_id, String d_name, String d_qualification, 
                      String d_designation, double d_salary, String d_department) throws SQLException;
    void deleteDoctor(int d_id) throws SQLException;
    Doctor searchDoctor(String d_name) throws SQLException;
    void viewAllDoctors() throws SQLException;

    void addAppointment(Date a_date, Time a_time, String a_type, int p_id, int d_id) throws SQLException;
    void deleteAppointment(int a_id) throws SQLException;

    void addBill(Date b_date, double b_amount, String b_payer, int a_id) throws SQLException;
    void viewAllBills() throws SQLException;

    void doctorWisePatientReport() throws SQLException;
    void dateWiseBillReport(Date report_date) throws SQLException;
    void patientWiseBillReport(int patient_id) throws SQLException;
}
