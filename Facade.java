import java.util.*;

interface advice {
    public void giveAdvice();
}

class diet implements advice {
    public void giveAdvice() {
        System.out.println("proper diet plan");
    }
}

class exercise implements advice {
    public void giveAdvice() {
        System.out.println("proper exercise plan");
    }
}

class GYM implements advice {
    public void giveAdvice() {
        System.out.println("proper GYM plan");
    }
}

class Yoga implements advice{
    public void giveAdvice() {
        System.out.println("proper Yoga plan");
    }
}

class assist {
    private diet dietPlan;
    private exercise exe;
    private GYM g;
    private Yoga y;

    public assist() {
        dietPlan = new diet();
        exe = new exercise();
        g = new GYM();
        y = new Yoga();
    }

    public void giveDietAdvice() {
        dietPlan.giveAdvice();
    }

    public void giveExerciseAdvice() {
        exe.giveAdvice();
    }

    public void giveGYMAdvice() {
        g.giveAdvice();
    }

    public void giveYogaAdvice() {
        y.giveAdvice();
    }
}
public class Facade {
    public static void main (String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your weight(kg) & hight(m)");
        double weight = sc.nextDouble();
        double height = sc.nextDouble();
        double BMI = (weight/Math.pow(height, 2));
        System.out.println("BMI : "+BMI);
        assist a = new assist();
        if (BMI < 18.5) {
            System.out.println("Underweight");
            a.giveDietAdvice();
        } else if (BMI >= 18.5 && BMI <= 24.9) {
            System.out.println("Normal");
            a.giveYogaAdvice();
            a.giveExerciseAdvice();
        } else if (BMI >= 25 && BMI <= 29.9) {
            System.out.println("Overweight");
            a.giveGYMAdvice();
            a.giveDietAdvice();
        } else if (BMI >= 30) {
            System.out.println("Obese");
            a.giveGYMAdvice();
            a.giveYogaAdvice();
            a.giveDietAdvice();
        }
    }
}