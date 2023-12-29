// Patient class
class Patient {
    private String name;
    private int age;
    private double weight;
    private double height;

    public Patient(String name, int age, double weight, double height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
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

    public double getHeight() {
        return this.height;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", Age: " + this.age + ", Weight: " + this.weight + " kg, Height: " + this.height + " m";
    }
}

// Assessment class
class Assessment {
    private double weight;
    private double height;

    public Assessment(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public double getWeight() {
        return this.weight;
    }

    public double getHeight() {
        return this.height;
    }

    public double getBMI() {
        return weight / (height * height);
    }
}

// Adapter interface
interface AssessmentAdapter {
    Assessment getAssessment(Patient patient);
}

// Concrete adapter class
class BMIAssessmentAdapter implements AssessmentAdapter {
    public Assessment getAssessment(Patient patient) {
        return new Assessment(patient.getWeight(), patient.getHeight());
    }
}

// Example usage
public class adapter {
    public static void main(String[] args) {
        // Create some patients
        Patient patient1 = new Patient("Smit", 20, 82.5, 1.75);
        Patient patient2 = new Patient("Parth", 25, 67.9, 1.62);
        Patient patient3 = new Patient("Punit", 22, 94.2, 1.83);

        // Create an adapter to get assessments
        AssessmentAdapter adapter = new BMIAssessmentAdapter();

        // Get assessments for each patient
        Assessment assessment1 = adapter.getAssessment(patient1);
        Assessment assessment2 = adapter.getAssessment(patient2);
        Assessment assessment3 = adapter.getAssessment(patient3);

        // Print out patient information and assessment results
        System.out.println(patient1 + ", BMI: " + assessment1.getBMI());
        System.out.println(patient2 + ", BMI: " + assessment2.getBMI());
        System.out.println(patient3 + ", BMI: " + assessment3.getBMI());
    }
}
