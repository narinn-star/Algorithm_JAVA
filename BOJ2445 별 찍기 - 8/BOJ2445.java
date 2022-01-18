import java.util.Scanner;

public class BOJ2445 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i = 0; i < N-1; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			for(int k = 0; k < (2*N)-(2*i + 2); k++) {
				System.out.print(" ");
			}
			for(int l = 0; l <= i; l++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i = 0; i < 2 * N; i++) {
			System.out.print("*");
		}
		System.out.println();
		for(int i = 0; i < N - 1; i++) {
			for(int j = 0; j < N - i - 1; j++) {
				System.out.print("*");
			}
			for(int k = 0; k < 2 * i + 2; k++) {
				System.out.print(" ");
			}
			for(int l = 0; l < N - i - 1; l++) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
	}

}
