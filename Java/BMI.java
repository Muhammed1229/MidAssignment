import java.util.Scanner;
class weight {
    double w;
    Scanner scanner = new Scanner(System.in);
    void inweight() {
    IO.println ("Enter your Weight in Kilograms: ");
    w = scanner.nextDouble();
    }
}

class height extends weight {
    double h;
    void inheight() {
    IO.println ("Enter your Height in Meters: ");
    h = scanner.nextDouble();
}
}

public class BMI extends height {
    double result;
    double BMIcal() {
        result = w/Math.pow(h, 2);
        return result;
    }
    String outcome() {
    if (result < 18.5) {
        return ("You are UnderWeight.");
    }else if (result >= 18.5 && result < 25) {
        return ("You are Healthy.");
    }else if (result >= 25 && result < 30){
        return ("You are Overweight.");
    }else {
        return ("You are Obese.");
    } 
    }
void main () {
    BMI B1 = new BMI();
    B1.inweight();
    B1.inheight();
    double bmi = B1.BMIcal();
    String out = B1.outcome();
    IO.println("Your BMI is: " + bmi + " and " + out);
}
}