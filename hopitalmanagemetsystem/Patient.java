package hopitalmanagemetsystem;

public class Patient {
    private int p_id;
    private String name;
    private String disease; // Changed from medical_problem to disease
    private int age;
    private String phone_number; // Changed from ph_no to phone_number
    
    public Patient(String name, String disease, int age, String phone_number) {
        this.name = name;
        this.disease = disease;
        this.age = age;
        this.phone_number = phone_number;
    }

    public Patient(int p_id, String name, String disease, int age, String phone_number) {
        this.p_id = p_id;
        this.name = name;
        this.disease = disease;
        this.age = age;
        this.phone_number = phone_number;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "p_id=" + p_id +
                ", name='" + name + '\'' +
                ", disease='" + disease + '\'' +
                ", age=" + age +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}