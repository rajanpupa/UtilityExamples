package scanner;

import java.util.Scanner;

public class ScannerTest1 {

	static int solveMeSecond(int a, int b) {
        return a+b;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t;
        int sum;
        int a,b;
        t = in.nextInt();
        String line;
        String[] nums ;
        
        for (int i=0;i<t;i++) {
            a = in.nextInt();
            b = in.nextInt();
            sum = solveMeSecond(a, b);
            System.out.println(sum);
        }
    }
}
