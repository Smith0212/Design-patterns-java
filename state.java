interface PatientState {
    void discharge(Patient patient);
    void diagnose(Patient patient);
    String getStateName();
}

class InHospitalState implements PatientState {
    @Override
    public void discharge(Patient patient) {
        System.out.println("Patient " + patient.getName() + " is discharged.");
        patient.setState(new DischargedState());
    }

    @Override
    public void diagnose(Patient patient) {
        System.out.println("Patient " + patient.getName() + " is being diagnosed in hospital.");
    }

    @Override
    public String getStateName() {
        return "In Hospital";
    }
}

class DischargedState implements PatientState {
    @Override
    public void discharge(Patient patient) {
        System.out.println("Patient " + patient.getName() + " is already discharged.");
    }

    @Override
    public void diagnose(Patient patient) {
        System.out.println("Patient " + patient.getName() + " has been discharged, diagnosis not possible.");
    }

    @Override
    public String getStateName() {
        return "Discharged";
    }
}

class Patient {
    private String name;
    private int age;
    private String gender;
    private PatientState state;

    public Patient(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.state = new InHospitalState();
    }

    public void setState(PatientState state) {
        this.state = state;
    }

    public void discharge() {
        this.state.discharge(this);
    }

    public void diagnose() {
        this.state.diagnose(this);
    }
    
    public String getStateName() {
        return state.getStateName();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}

public class state {
    public static void main(String[] args) {
        Patient patient1 = new Patient("Smit", 33, "Male");
        patient1.diagnose();
        System.out.println("Patient name: " + patient1.getName() + ", age: " + patient1.getAge() + ", gender: "
                + patient1.getGender() + ",\nSTATE: " + patient1.getStateName());
        System.out.println();
        
        patient1.discharge();
        System.out.println("Patient name: " + patient1.getName() + ", age: " + patient1.getAge() + ", gender: "
                + patient1.getGender() + ",\nSTATE: " + patient1.getStateName());
        System.out.println();

        patient1.discharge();
        System.out.println("Patient name: " + patient1.getName() + ", age: " + patient1.getAge() + ", gender: "
                + patient1.getGender() + ",\nSTATE: " + patient1.getStateName());
        System.out.println();

        patient1.diagnose();
        System.out.println("Patient name: " + patient1.getName() + ", age: " + patient1.getAge() + ", gender: "
                + patient1.getGender() + ",\nSTATE: " + patient1.getStateName());
        System.out.println();
    }
}
