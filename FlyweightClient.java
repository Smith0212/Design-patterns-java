import java.util.HashMap;
import java.util.Map;

// Flyweight interface
interface Patient {
    void getAppointmentDetails();
}

// Concrete Flyweight
class MalePatient implements Patient {
    private String name;
    private String age;
    private String gender;
    private Assist Consultant;

    public MalePatient(String name, String age, Assist Consultant) {
        this.name = name;
        this.age = age;
        this.gender = "Male";
        this.Consultant = Consultant;
    }

    @Override
    public void getAppointmentDetails() {
        System.out.println("Patient Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        Consultant.getAppointment();
    }
}

// Concrete Flyweight
class FemalePatient implements Patient {
    private String name;
    private String age;
    private String gender;
    private Assist Consultant;

    public FemalePatient(String name, String age, Assist Consultant) {
        this.name = name;
        this.age = age;
        this.gender = "Female";
        this.Consultant = Consultant;
    }

    @Override
    public void getAppointmentDetails() {
        System.out.println("Patient Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        Consultant.getAppointment();
    }
}

// Flyweight Factory
class PatientFactory {
    private static final HashMap<String, Patient> patients = new HashMap<>();

    public static Patient getPatient(String name, String age, String gender, Assist Consultant) {
        String key = name + "_" + gender;
        Patient patient = patients.get(key);

        if (patient == null) {
            if (gender.equalsIgnoreCase("male")) {
                patient = new MalePatient(name, age, Consultant);
            } 
            else {
                patient = new FemalePatient(name, age, Consultant);
            }
            patients.put(key, patient);
        }
        return patient;
    }
}

class Assist {
    private String name;
    private String appointment;

    public Assist(String name, String appointment) {
        this.name = name;
        this.appointment = appointment;
    }

    public void getAppointment() {
        System.out.println("Consultant Name: " + name);
        System.out.println("Appointment Approve: " + appointment);
    }
}

// Client
public class FlyweightClient {
    public static void main(String[] args) {
        Assist Consultant = new Assist("Raju", "YES");

        Patient patient1 = PatientFactory.getPatient("Smit", "35", "male", Consultant);
        patient1.getAppointmentDetails();
        System.out.println();

        Patient patient2 = PatientFactory.getPatient("janki", "30", "female", Consultant);
        patient2.getAppointmentDetails();
        System.out.println();

        Patient patient3 = PatientFactory.getPatient("Smit", "36", "male", Consultant);
        patient3.getAppointmentDetails();
        System.out.println();

        System.out.println("patient1 and patient3 are the same object: " + (patient1 == patient3));
        System.out.println();
    }
}
