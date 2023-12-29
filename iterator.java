import java.util.ArrayList;
import java.util.List;

interface PatientIterator {
    boolean hasNext();
    PatientData next();
}

interface PatientContainer {
    PatientIterator getPatientIterator();
}

class PatientData {
    private String name;
    private int age;
    private String gender;
    private double weight;
    private double height;

    public PatientData(String name, int age, String gender, double weight, double height) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
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

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }
}

class ObesityPatientRepository implements PatientContainer {
    private List<PatientData> patients = new ArrayList<>();

    // constructor to add patients to the repository
    public ObesityPatientRepository() {
        patients.add(new PatientData("Smit", 35, "Male", 90.5, 1.82));
        patients.add(new PatientData("helly", 28, "Female", 65.2, 1.68));
        patients.add(new PatientData("Parth", 42, "Male", 110.8, 1.92));
    }

    @Override
    public PatientIterator getPatientIterator() {
        return new ObesityPatientIterator();
    }

    private class ObesityPatientIterator implements PatientIterator {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < patients.size();
        }

        @Override
        public PatientData next() {
            if (this.hasNext()) {
                return patients.get(index++);
            }
            return null;
        }
    }
}

public class iterator {
    public static void main(String[] args) {
        ObesityPatientRepository patientRepository = new ObesityPatientRepository();

        PatientIterator patientIterator = patientRepository.getPatientIterator();
        while (patientIterator.hasNext()) {
            PatientData patient = patientIterator.next();
            System.out.println("Name: " + patient.getName() + ", Age: " + patient.getAge() + ", Gender: " +
                    patient.getGender() + ", Weight: " + patient.getWeight() + ", Height: " + patient.getHeight());
        }
    }
}


