// The Patient interface
interface Patient {
    public void requestAssistance();
}

// The concrete Patient class
class ConcretePatient implements Patient {
    @Override
    public void requestAssistance() {
        System.out.println("Patient requested assistance.");
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
        System.out.println("Assistant provided additional assistance.");
    }
}

// Example usage
public class Decorator {
    public static void main(String[] args) {
        // Create a concrete patient object
        Patient concretePatient = new ConcretePatient();
        
        // Wrap the concrete patient object with an assistant decorator
        Patient patientWithAssistant = new AssistantDecorator(concretePatient);
        
        // Call the requestAssistance method on the wrapped patient object
        patientWithAssistant.requestAssistance();
    }
}
