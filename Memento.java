import java.util.ArrayList;
import java.util.List;

class ObesityPatientHistory {
    private List<ObesityMemento> mementoList = new ArrayList<>();

    public void addMemento(ObesityMemento memento) {
        mementoList.add(memento);
    }

    public ObesityMemento getMemento(int index) {
        return mementoList.get(index);
    }
}

class ObesityMemento {
    private String name;
    private int age;
    private double weight;

    public ObesityMemento(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }
}

class ObesityPatient {
    private String name;
    private int age;
    private double weight;

    public ObesityPatient(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public ObesityMemento saveState() {
        return new ObesityMemento(name, age, weight);
    }

    public void restoreState(ObesityMemento memento) {
        this.name = memento.getName();
        this.age = memento.getAge();
        this.weight = memento.getWeight();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }
}

public class Memento {
    public static void main(String[] args) {
        ObesityPatient patient = new ObesityPatient("Smit", 40, 120.0);
        ObesityPatientHistory history = new ObesityPatientHistory();

        // Save the current state of the patient
        history.addMemento(patient.saveState());

        // Update the patient's weight
        patient.setWeight(130.0);

        // Save the new state of the patient
        history.addMemento(patient.saveState());

        // Restore the previous state of the patient
        patient.restoreState(history.getMemento(0));

        // Print the patient's name, age, and weight
        System.out.println("Patient name: " + patient.getName());
        System.out.println("Patient age: " + patient.getAge());
        System.out.println("Patient weight: " + patient.getWeight());
    }
}

