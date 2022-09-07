import java.util.Scanner;

public class CtoF {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Temperature in Celcius: ");
        // works with
        //double c = Double.parseDouble(keyboard.nextLine());
        double c = keyboard.nextDouble();
        double f = 9.0/5 * c + 32;
        System.out.println(c + " degrees Celcius is " + f + " degrees Fahrenheit.");
    }
}
