package com.ktm.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerTest2 {
	public static void main(String[] args) throws FileNotFoundException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		File file = new File("input.txt");
		Scanner sc = new Scanner(file);
		int size = sc.nextInt();
		long diagSum1 = 0;
		long diagSum2 = 0;

		int num=0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				num = sc.nextInt();
				if (i == j) {
					diagSum1 += num;
				}
				if ((i + j) == (size - 1)) {
					diagSum2 += num;
				}
			}
		}
		sc.close();
		
		if (diagSum1 > diagSum2) {
			System.out.print(diagSum1 - diagSum2);
		} else {
			System.out.print(diagSum2 - diagSum1);
		}
	}
}
