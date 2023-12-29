// Builder Design Pattern for bike class with its four main attributes by using setter methods
// Path: BikeBuilder.java
// Builder Design Pattern for bike class with its four main attributes by using setter methods

public class BikeBuilder {
    
    private String frame;
    private String Handlebar;
    private String Seat;
    private String Wheel;

    public BikeBuilder(){
        frame = "frame1";
        Handlebar = "Handlebar1";
        Seat = "Seat1";
        Wheel = "Wheel1";
    }

    public BikeBuilder buildFame(String frame) {
        this.frame = frame;
        return this;
    }
    
    public BikeBuilder buildHandlebar(String handlebar) {
        this.Handlebar = handlebar;
        return this;
    }
    
    public BikeBuilder buildSeat(String seat) {
        this.Seat = seat;
        return this;
    }
    
    public BikeBuilder buildWheel(String wheel) {
        this.Wheel = wheel;
        return this;
    }

    public String toString(){
        return "frame = " + frame + ", Handlebar = " + Handlebar + ", Seat = " + Seat + ", Wheel = " + Wheel;
    }
    public static void main(String[] args) {
        BikeBuilder bike = new BikeBuilder()
                                .buildFrame("Frame2")
                                .buildHandlebar("Handlebar2");
                                // .buildSeat("Seat")
                                // .buildWheel("Wheel1");
        System.out.println(bike);
    }
}





