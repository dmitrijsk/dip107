package dip107;

import java.util.Random;
import java.util.Scanner;

public class Md4_000rdb000 {

	public static void main(String[] args) {
		
		System.out.println("000rdb000 Dmitrijs Kass");
		
		/* Aprakstīt divdimensiju masīvu, paredzētu Formulas 1 pilotu 
		 * aizņemto vietu glabāšanai dažādās sacīkstēs. 
		 * Pieņemsim, ka mūsu komandā ir 6 piloti un viņi piedalās 7 sacīkstēs. */
		int[][] A = {{3,	16,	1,	5,	1,	2,	3},
					 {2,	3,	2,	3,	2,	3,	2}, 
					 {12,	20,	25,	11,	30,	14,	15}, 
					 {5,	3,	5,	2,	3,	2,	3}, 
					 {1,	2,	3,	1,	2,	3,	1}, 
					 {14,	25,	17,	15,	11,	18,	16}};
		final int aRows = A.length;
		final int aCols = A[1].length;
		
		/* Uzdot lietotājam jautājumu, vai viņš vēlas aizpildīt masīvu 
		 * ar patvaļīgām vērtībām un pozitīvas atbildes gadījumā piešķirt 
		 * masīva elementiem patvaļīgas vērtības no diapazona [1; 30]. */
		Scanner sc = new Scanner(System.in);
		String ch = "n";
		System.out.print("Aizpildīt masīvu ar patvaļīgiem skaitļiem (y/n)? ");
		
		if (sc.hasNext()) {
			ch = sc.next();
			sc.close();
		} else {
			System.out.println("input-output error");
			sc.close();
			return;
		}
			
		Random rnd = new Random();
		final int randRange = 30;
		
		if (ch.toLowerCase().equals("y")) {
			for (int i=0; i < aRows; i++)
				for (int j=0; j < aCols; j++)
					A[i][j] = rnd.nextInt(randRange) + 1; // uniformly distributed int value between 0 (inclusive) and the specified value (exclusive).
		} else {
			if (!ch.toLowerCase().equals("n")) {
				System.out.println("input-output error");
				return;
			}
		}
		
		// Izvadīt masīva elementi (tabulas veidā).
		for (int i = 0; i < aRows; i++) {
			for (int j = 0; j < aCols; j++)
				System.out.print(A[i][j] + "\t");
			System.out.print("\n");
		}
				
		// Izvadīt ekrānā to pilotu numurus, kas vismaz vienā sacīkstē ieņēma 1. vietu.
		System.out.println("result:");
		for (int i = 0; i < aRows; i++) { // i = one row = results of one pilot.
			for (int j = 0; j < aCols; j++)	// [i,j] = one competition result.
				if (A[i][j] == 1) {
					System.out.print(i+1 + " ");
					break;
				}
		}
	}
}
