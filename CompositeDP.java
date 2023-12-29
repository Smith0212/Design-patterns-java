import java.util.ArrayList;
import java.util.List;

interface PatientComponent {
    double getTreatmentCost();
    void add(PatientComponent c);
}

class Patient implements PatientComponent {
    private String name;
    private int age;
    private double weight;
    private double consultantCost;

    public Patient(String name, int age, double weight, double consultantCost) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.consultantCost = consultantCost;
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

    @Override
    public double getTreatmentCost() {
        return this.consultantCost;
    }

    @Override
    public void add(PatientComponent c) {
        // This method is not applicable for this class
    }
}

class Treatment implements PatientComponent {
    private String treatmentName;
    private double cost;
    private List<PatientComponent> components = new ArrayList<>();

    public Treatment(String treatmentName, double cost) {
        this.treatmentName = treatmentName;
        this.cost = cost;
    }

    public String getTreatmentName() {
        return this.treatmentName;
    }

    public double getTreatmentCost() {
        double totalCost = cost;
        for (PatientComponent component : components) {
            totalCost += component.getTreatmentCost();
        }
        return totalCost;
    }

    @Override
    public void add(PatientComponent c) {
        components.add(c);
    }
}

public class CompositeDP {
    public static void main(String[] args) {
        Patient patient1 = new Patient("Smit", 19, 60.0, 100.0);
        Treatment treatment1 = new Treatment("X-ray", 1000.0);
        Treatment treatment2 = new Treatment("Blood Test", 500.0);
        Treatment treatment3 = new Treatment("Prescription", 200.0);

        treatment1.add(patient1);
        treatment1.add(treatment2);
        treatment2.add(treatment3);

        System.out.println("Patient: "  + patient1.getName() 
                                        + ", Age: " + patient1.getAge() 
                                        + ", Weight: " + patient1.getWeight());

        System.out.println("Treatments: "+ treatment1.getTreatmentName()+", "
                                        + treatment2.getTreatmentName()+", "
                                        + treatment3.getTreatmentName()+",\ntotalCost: " 
                                        + treatment1.getTreatmentCost());
    }
}
