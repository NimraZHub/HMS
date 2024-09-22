package hopitalmanagemetsystem;
import java.util.Date;

public class Appointment {
    private int appointment_id; 
    private Date appointment_date; 
    private String appointment_time; 
    private String appointment_type; 
    private int patient_id;
    private int doctor_id;

    public Appointment(String appointment_type, Date appointment_date, String appointment_time, int doctor_id, int patient_id) {
        this.appointment_type = appointment_type;
        this.appointment_date = appointment_date; 
        this.appointment_time = appointment_time;
        this.doctor_id = doctor_id; 
        this.patient_id = patient_id;
    }

    public Appointment(int appointment_id, String appointment_type, Date appointment_date, String appointment_time, int doctor_id, int patient_id) {
        this.appointment_id = appointment_id; 
        this.appointment_type = appointment_type; 
        this.appointment_date = appointment_date; 
        this.appointment_time = appointment_time; 
        this.doctor_id = doctor_id; 
        this.patient_id = patient_id;
    }

    public int getAppointment_id() { 
        return appointment_id;
    }

    public void setAppointment_id(int appointment_id) { 
        this.appointment_id = appointment_id;
    }

    public Date getAppointment_date() { 
        return appointment_date;
    }

    public void setAppointment_date(Date appointment_date) { 
        this.appointment_date = appointment_date;
    }

    public String getAppointment_time() { 
        return appointment_time;
    }

    public void setAppointment_time(String appointment_time) { 
        this.appointment_time = appointment_time;
    }

    public String getAppointment_type() { 
        return appointment_type;
    }

    public void setAppointment_type(String appointment_type) { 
        this.appointment_type = appointment_type;
    }

    public int getPatient_id() { 
        return patient_id;
    }

    public void setPatient_id(int patient_id) { 
        this.patient_id = patient_id;
    }

    public int getDoctor_id() { 
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) { 
        this.doctor_id = doctor_id;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointment_id=" + appointment_id + // 
                ", appointment_date=" + appointment_date + 
                ", appointment_time='" + appointment_time + '\'' + 
                ", appointment_type='" + appointment_type + '\'' + 
                ", patient_id=" + patient_id + 
                ", doctor_id=" + doctor_id + 
                '}';
    }
}
