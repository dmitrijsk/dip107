
/**
 * DIP107 Homework #1.
 * 
 * @author Dmitrijs Kass
 * @version 0.0.1
 */

import java.util.Scanner;
import edu.duke.*;

public class Md1_000RDB000_Dmitrijs_Kass {

    private Float[] getCoordsFromConsole() {

        /*This method gets X and Y coordinates from the console and returns a Float array.
        If any of the console inputs are not float numbers then it stays null. */

        Float[] coords = new Float[2]; // Initialized to null.
        Scanner sc = new Scanner(System.in);       

        // x input.
        System.out.print("x = ");
        if (sc.hasNextFloat()) {
            coords[0] = sc.nextFloat();
        } else {
            sc.close();
            return coords;
        }

        // y input.
        System.out.print("y = ");
        if (sc.hasNextFloat()) {
            coords[1] = sc.nextFloat();
        } else {
            sc.close();
            return coords;
        }
        sc.close();

        return coords; // Return X-Y coordinates.
    }

    private String colorFromCoords(Float[] coords) {

        /* This method gets X-Y coordinates and returns a corresponding color. */

        String result;

        float x = coords[0];
        float y = coords[1];

        if (((x - 3.5)*(x - 3.5) + (y-8)*(y-8) <= 0.5*0.5) ||   // left half-circle.
            ((x - 10.5)*(x - 10.5) + (y-8)*(y-8) <= 0.5*0.5)) { // right half-circle.
            result = "green";
        } else if ((y <= x+5 && y <= -x+19 && y >= 11) || // top.
                    (y <= x+3 && y >= 4 && x <= 6) ||     // left wing.
                    (y <= -x+17 && y >= 4 && x >= 8)) {   // right wing.
            result = "blue";
        } else if ((x >= 3 && x <= 4 & y <= 8 && y >= x+3 ) ||      // left rocket.
                    (x >= 10 && x <= 11 && y <= 8 && y >= -x+17) || // right rocket.
                    (y >= 3 && y <= 11 && x >= 6 && x <= 8)) {      // body.
            result = "red";
        } else {
            result = "white";
        }

        return result; // Return a color string.
    }

    public void tester() {

        /* This is a tester method that gets test cases from a tab-delimited TXT file. 
        It returns either a "Correct" or a "Wrong" string. */

        FileResource fr = new FileResource();
        for (String line : fr.lines()) {
            String[] testCase = line.split("\t");
            Float[] testCoords = {Float.valueOf(testCase[0]), 
                    Float.valueOf(testCase[1])};
            String expResult = testCase[2];
            String actResult = colorFromCoords(testCoords);
            
            if (expResult.equals(actResult)) {
                System.out.print("Correct. ");
            } else {
                System.out.print("Wrong! ");
            }
            
            System.out.print("x=" + testCoords[0] + ", y=" + testCoords[1]);
            System.out.println(". Exp: " + expResult + ", Act: " + actResult);
        }   
    }

    public void checkColour() {

        /* This method gets X-Y coordinates from the user and check what color corresponds to them. 
        If any of the coordinates are not float numbers then it returns "IO Error" message and terminates. */

        System.out.println("Dmitrijs Kass");
        Float[] consoleCoords = getCoordsFromConsole();
        if (consoleCoords[0] == null || consoleCoords[1] == null) {
            System.out.println("IO Error.");
            return;   
        }
        System.out.println(colorFromCoords(consoleCoords));
    }
}
