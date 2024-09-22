package hopitalmanagemetsystem;

import java.util.Date;

public class Bill {
    private int bill_ID;
    private Date bill_date;
    private double payable_amount;
    private String payer_name;
    private int appointment_id;

    public Bill(int appointment_id, String payer_name, double payable_amount, Date bill_date) {
        this.appointment_id = appointment_id;
        this.payer_name = payer_name;
        this.payable_amount = payable_amount;
        this.bill_date = bill_date;
    }

    public Bill(int bill_ID, Date bill_date, double payable_amount, String payer_name, int appointment_id) {
        this.bill_ID = bill_ID;
        this.bill_date = bill_date;
        this.payable_amount = payable_amount;
        this.payer_name = payer_name;
        this.appointment_id = appointment_id;
    }

    public int getBill_ID() {
        return bill_ID;
    }

    public void setBill_ID(int bill_ID) {
        this.bill_ID = bill_ID;
    }

    public Date getBill_date() {
        return bill_date;
    }

    public void setBill_date(Date bill_date) {
        this.bill_date = bill_date;
    }

    public double getPayable_amount() {
        return payable_amount;
    }

    public void setPayable_amount(double payable_amount) {
        this.payable_amount = payable_amount;
    }

    public String getPayer_name() {
        return payer_name;
    }

    public void setPayer_name(String payer_name) {
        this.payer_name = payer_name;
    }

    public int getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "bill_ID=" + bill_ID +
                ", bill_date=" + bill_date +
                ", payable_amount=" + payable_amount +
                ", payer_name='" + payer_name + '\'' +
                ", appointment_id=" + appointment_id +
                '}';
    }
}