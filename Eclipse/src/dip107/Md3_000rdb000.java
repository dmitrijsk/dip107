package dip107;

import java.util.Random;
import java.util.Scanner;

public class Md3_000rdb000 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[] A = new double[20]; // Masīvs A no 20 tipa double skaitļiem. 
		float K; // Reāls skaitlis K. 
		
		System.out.println("000rdb000 Dmitrijs Kass");
	
		// Ievadīt reālo skaitli K. 
		System.out.print("K = ");
		if (sc.hasNextFloat()) {
			K = sc.nextFloat();
		} else {
			System.out.println("input-output error");
			sc.close();
			return;
		}
		sc.close();
		
		System.out.println("result:");
		
		if (K >= 0) {
			/* Ja skaitlis K ir vienāds ar nulli vai pozitīvs, 
			 * tad aizpildīt masīvu A ar patvaļīgiem reāliem skaitļiem 
			 * no diapazona no -50 līdz 50. */
			Random r = new Random();
			for (int i=0; i < A.length; i++) {
				A[i] = r.nextDouble() * 100 - 50;
			}
		} else {
			/* Ja skaitlis K negatīvs, tad masīva A pirmajam elementam 
			 * (elementam A[0]) piešķirt vērtību 0.1. 
			 * Bet katra nākošā elementa vērtību aprēķināt izmantojot izteiksmi: 
			 * A[i] = A[i-1]*K. */
			A[0] = 0.1;
			for (int i=1; i < A.length; i++) {
				A[i] = A[i-1] * K;
			}
		}
		
		// Izvadīt masīva A elementus ekrānā (pa 5 elementiem vienā rindā).
		System.out.println("A:");
		int j = 0;
		while (j < A.length) {
			System.out.printf("%.2f\t", A[j]);
			if ((j+1) % 5 == 0) System.out.println("\n");
			j++;
		}
		
		/* No masīva A elementiem izveidot masīvu B. 
		 * Masīva B sākumā izvietot visus pozitīvos masīva A elementus, 
		 * bet pēc tam negatīvos. 
		 * Pozitīvo un negatīvo elementu savstarpējo secību mainīt ir aizliegts. */
		double[] B = new double[A.length];
		int n = 0;
		
		j = 0;
		do {
			if (A[j] >= 0) {
				B[n] = A[j];
				n++;
			}
			j++;
		} while(j < B.length);

		j = 0;
		do {
			if (A[j] < 0) {
				B[n] = A[j];
				n++;
			}
			j++;
		} while(j < B.length);
		
		// Izvadīt ekrānā masīva B elementus (pa 5 elementiem vienā rindā).
		System.out.println("\nB:");
		for (int i=0; i < B.length; i++) {
			System.out.printf("%.2f\t", B[i]);
			if ((i+1) % 5 == 0) System.out.println("\n");
		}
	}

	
}
