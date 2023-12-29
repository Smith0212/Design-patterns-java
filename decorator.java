// The Patient interface
interface Patient {
    public void requestAssistance();
}

// The concrete Patient class
class ConcretePatient1 implements Patient {
    @Override
    public void requestAssistance() {
        System.out.println("Patient requested assistance.");
    }
}

class ConcretePatient2 implements Patient {
    @Override
    public void requestAssistance() {
        System.out.println("Patient requested treatment.");
    }
}

// The abstract Decorator class
abstract class PatientDecorator implements Patient {
    private Patient patient;

    public PatientDecorator(Patient patient) {
        this.patient = patient;
    }

    @Override
    public void requestAssistance() {
        patient.requestAssistance();
    }
}

// The concrete AssistantDecorator class
class AssistantDecorator extends PatientDecorator {
    public AssistantDecorator(Patient patient) {
        super(patient);
    }

    @Override
    public void requestAssistance() {
    super.requestAssistance();
    System.out.println("Assistant provided additional assistance and treatment.");
    }
}

// Example usage
public class decorator {
    public static void main(String[] args) {
    // Create a concrete patient object
    Patient concretePatient1 = new ConcretePatient1();
    Patient concretePatient2 = new ConcretePatient2();

    // Wrap the concrete patient object with an assistant decorator
    Patient patientWithAssistant = new AssistantDecorator(concretePatient1);
    Patient patientGetTreatment = new AssistantDecorator(concretePatient2);

    // Call the requestAssistance method on the wrapped patient object
    System.out.println("patient get assistant :");
    patientWithAssistant.requestAssistance();
    System.out.println();
    System.out.println("patient get treatment :");
    patientGetTreatment.requestAssistance();
    }
}
