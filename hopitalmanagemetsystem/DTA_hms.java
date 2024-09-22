package hopitalmanagemetsystem;

import java.sql.*;

public class DTA_hms implements DAO_hms {
   private final Connection connection;

    public DTA_hms(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addPatient(String p_name, int p_age, String p_disease, String p_phone_number) throws SQLException {
        String query = "{CALL addPatient(?, ?, ?, ?)}";
        try (CallableStatement stmt = connection.prepareCall(query)) {
            stmt.setString(1, p_name);
            stmt.setInt(2, p_age);
            stmt.setString(3, p_disease);
            stmt.setString(4, p_phone_number);
            stmt.execute();
        }
    }

    @Override
    public void updatePatient(int p_id, String p_name, int p_age, String p_disease, String p_phone_number) throws SQLException {
        String query = "{CALL updatePatient(?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = connection.prepareCall(query)) {
            stmt.setInt(1, p_id);
            stmt.setString(2, p_name);
            stmt.setInt(3, p_age);
            stmt.setString(4, p_disease);
            stmt.setString(5, p_phone_number);
            stmt.execute();
        }
    }

    @Override
    public void deletePatient(int p_id) throws SQLException {
        String query = "{CALL deletePatient(?)}";
        try (CallableStatement stmt = connection.prepareCall(query)) {
            stmt.setInt(1, p_id);
            stmt.execute();
        }
    }

    @Override
    public Patient searchPatient(String p_name) throws SQLException {
        String query = "{CALL searchPatient(?)}";
        try (CallableStatement stmt = connection.prepareCall(query)) {
            stmt.setString(1, p_name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Patient(
                    rs.getInt("p_ID"),
                    rs.getString("name"),
                    rs.getString("disease"),
                    rs.getInt("age"),
                    rs.getString("phone_number")
                );
            }
        }
        return null;
    }

    @Override
    public void viewAllPatients() throws SQLException {
        String query = "{CALL viewAllPatients()}";
        try (CallableStatement stmt = connection.prepareCall(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("p_ID") +
                                   ", Name: " + rs.getString("name") +
                                   ", Age: " + rs.getInt("age") +
                                   ", Disease: " + rs.getString("disease") +
                                   ", Phone: " + rs.getString("phone_number"));
            }
        }
    }

    @Override
    public void addDoctor(String d_name, String d_qualification, String d_designation, double d_salary, String d_department) throws SQLException {
        String query = "{CALL addDoctor(?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = connection.prepareCall(query)) {
            stmt.setString(1, d_name);
            stmt.setString(2, d_qualification);
            stmt.setString(3, d_designation);
            stmt.setDouble(4, d_salary);
            stmt.setString(5, d_department);
            stmt.execute();
        }
    }

    @Override
    public void updateDoctor(int d_id, String d_name, String d_qualification, String d_designation, double d_salary, String d_department) throws SQLException {
        String query = "{CALL updateDoctor(?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = connection.prepareCall(query)) {
            stmt.setInt(1, d_id);
            stmt.setString(2, d_name);
            stmt.setString(3, d_qualification);
            stmt.setString(4, d_designation);
            stmt.setDouble(5, d_salary);
            stmt.setString(6, d_department);
            stmt.execute();
        }
    }

    @Override
    public void deleteDoctor(int d_id) throws SQLException {
        String query = "{CALL deleteDoctor(?)}";
        try (CallableStatement stmt = connection.prepareCall(query)) {
            stmt.setInt(1, d_id);
            stmt.execute();
        }
    }

    @Override
    public Doctor searchDoctor(String d_name) throws SQLException {
        String query = "{CALL searchDoctor(?)}";
        try (CallableStatement stmt = connection.prepareCall(query)) {
            stmt.setString(1, d_name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Doctor(
                    rs.getInt("d_ID"),
                    rs.getString("name"),
                    rs.getString("qualification"),
                    rs.getString("designation"),
                    rs.getDouble("salary"),
                    rs.getString("department")
                );
            }
        }
        return null;
    }

    @Override
    public void viewAllDoctors() throws SQLException {
        String query = "{CALL viewAllDoctors()}";
        try (CallableStatement stmt = connection.prepareCall(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("d_ID") +
                                   ", Name: " + rs.getString("name") +
                                   ", Qualification: " + rs.getString("qualification") +
                                   ", Designation: " + rs.getString("designation") +
                                   ", Salary: " + rs.getDouble("salary") +
                                   ", Department: " + rs.getString("department"));
            }
        }
    }

    @Override
    public void addAppointment(Date a_date, Time a_time, String a_type, int p_id, int d_id) throws SQLException {
        String query = "{CALL addAppointment(?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = connection.prepareCall(query)) {
            stmt.setDate(1, a_date);
            stmt.setTime(2, a_time);
            stmt.setString(3, a_type);
            stmt.setInt(4, p_id);
            stmt.setInt(5, d_id);
            stmt.execute();
        }
    }

    @Override
    public void deleteAppointment(int a_id) throws SQLException {
        String query = "{CALL deleteAppointment(?)}";
        try (CallableStatement stmt = connection.prepareCall(query)) {
            stmt.setInt(1, a_id);
            stmt.execute();
        }
    }

    @Override
    public void addBill(Date b_date, double b_amount, String b_payer, int a_id) throws SQLException {
        String query = "{CALL addBill(?, ?, ?, ?)}";
        try (CallableStatement stmt = connection.prepareCall(query)) {
            stmt.setDate(1, b_date);
            stmt.setDouble(2, b_amount);
            stmt.setString(3, b_payer);
            stmt.setInt(4, a_id);
            stmt.execute();
        }
    }

    @Override
    public void viewAllBills() throws SQLException {
        String query = "{CALL viewAllBills()}";
        try (CallableStatement stmt = connection.prepareCall(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("Bill ID: " + rs.getInt("bill_ID") +
                                   ", Date: " + rs.getDate("bill_date") +
                                   ", Amount: " + rs.getDouble("payable_amount") +
                                   ", Payer: " + rs.getString("payer_name") +
                                   ", Appointment ID: " + rs.getInt("appointment_id"));
            }
        }
    }

    @Override
    public void doctorWisePatientReport() throws SQLException {
        String query = "{CALL doctorWisePatientReport()}";
        try (CallableStatement stmt = connection.prepareCall(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("Doctor: " + rs.getString("doctor_name") +
                                   ", Patient Count: " + rs.getInt("patient_count"));
            }
        }
    }

    @Override
    public void dateWiseBillReport(Date report_date) throws SQLException {
        String query = "{CALL dateWiseBillReport(?)}";
        try (CallableStatement stmt = connection.prepareCall(query)) {
            stmt.setDate(1, report_date);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    System.out.println("Bill ID: " + rs.getInt("bill_ID") +
                                       ", Date: " + rs.getDate("bill_date") +
                                       ", Amount: " + rs.getDouble("payable_amount") +
                                       ", Payer: " + rs.getString("payer_name") +
                                       ", Appointment ID: " + rs.getInt("appointment_ID"));
                }
            }
        }
    }

    @Override
    public void patientWiseBillReport(int patient_id) throws SQLException {
        String query = "{CALL patientWiseBillReport(?)}";
        try (CallableStatement stmt = connection.prepareCall(query)) {
            stmt.setInt(1, patient_id);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    System.out.println("Patient: " + rs.getString("patient_name") +
                                       ", Bill ID: " + rs.getInt("bill_ID") +
                                       ", Date: " + rs.getDate("bill_date") +
                                       ", Amount: " + rs.getDouble("payable_amount"));
                }
            }
        }
    }
}
