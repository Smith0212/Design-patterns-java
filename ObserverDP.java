import java.util.ArrayList;
import java.util.List;

interface Subject {
    void registerObserver(Observer observer);

    void unregisterObserver(Observer observer);

    void notifyObservers();
}

interface Observer {
    void update();
}

class Obesity  implements Subject {
    private List<Observer> observers;
    private boolean isObese;

    public Obesity () {
        observers = new ArrayList<>();
    }

    public void setObese(boolean isObese) {
        this.isObese = isObese;
        notifyObservers();
    }

    public boolean isObese() {
        return isObese;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

class Detector implements Observer {
    private boolean isObese;
    private Subject subject;

    public Detector(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update() {
        if (subject instanceof Obesity ) {
            Obesity  Obesity  = (Obesity ) subject;
            isObese = Obesity .isObese();
            System.out.println("Detector is updated. The Obesity  is " + (isObese ? "opaque" : "transparent"));
        }
    }
}

public class ObserverDP {
    public static void main(String[] args) {
        Obesity  Obesity  = new Obesity ();
        Detector detector = new Detector(Obesity );
        Obesity .setObese(true);
    }
}
