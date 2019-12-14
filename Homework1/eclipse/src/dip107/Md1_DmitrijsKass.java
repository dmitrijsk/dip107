package dip107;

import java.util.Scanner;

public class Md1_DmitrijsKass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float x=0, y=0;
		String result;
		
		System.out.println("Dmitrijs Kass");
				
		// x input.
		System.out.print("x = ");
		if (sc.hasNextFloat()) {
			x = sc.nextFloat();
		} else {
			System.out.println("IO Error");
			sc.close();
			return;
		}
		
		// y input.
		System.out.print("y = ");
		if (sc.hasNextFloat()) {
			y = sc.nextFloat();
		} else {
			System.out.println("IO Error");
			sc.close();
			return;
		}
		sc.close();
		
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
		System.out.println(result);
	}

}
