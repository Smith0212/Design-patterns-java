
class PatientFactory {
    private static PatientFactory instance = null;

    private PatientFactory() {
    }

    public static PatientFactory getInstance() {
        if (instance == null) {
            instance = new PatientFactory();
        }
        return instance;
    }

    public Patient createPatient(String name, int age, double weight) {
        return new Patient(name, age, weight);
    }
}

class AssessmentFactory {
    private static AssessmentFactory instance = null;

    private AssessmentFactory() {
    }

    public static AssessmentFactory getInstance() {
        if (instance == null) {
            instance = new AssessmentFactory();
        }
        return instance;
    }

    public Assessment createAssessment(double weight, double height, double bmi) {
        return new Assessment(weight, height, bmi);
    }
}

class Patient {
    private String name;
    private int age;
    private double weight;

    public Patient(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public double getWeight() {
        return this.weight;
    }
}

class Assessment {
    private double weight;
    private double height;
    private double bmi;

    public Assessment(double weight, double height, double bmi) {
        this.weight = weight;
        this.height = height;
        this.bmi = bmi;
    }

    public double getWeight() {
        return this.weight;
    }

    public double getHeight() {
        return this.height;
    }

    public double getBMI() {
        return this.bmi;
    }
}

public class singleton {
    public static void main(String[] args) {
        PatientFactory patientFactory = PatientFactory.getInstance();
        Patient patient1 = patientFactory.createPatient("Smit",
                19, 60.0);
        System.out.println("Patient 1: " + patient1.getName() +
                ", Age: " + patient1.getAge() + ", Weight: "
                + patient1.getWeight());

        AssessmentFactory assessmentFactory = AssessmentFactory.getInstance();
        Assessment assessment1 = assessmentFactory.createAssessment(75.0, 180.0, 23.5);
        System.out.println("Assessment 1: Weight: " +
                assessment1.getWeight() + ", Height: " + assessment1.getHeight()
                + ", BMI: " + assessment1.getBMI());
    }
}
