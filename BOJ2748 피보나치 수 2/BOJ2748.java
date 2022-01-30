import java.util.Scanner;

public class BOJ2748 {
	static long[] fibonacci = new long[91];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		fibonacci[0] = 0;
		fibonacci[1] = 1;
		fibonacci();
		System.out.println(fibonacci[n]);
		sc.close();
	}
	public static void fibonacci() {
		for(int i = 2; i < fibonacci.length; i++) {
			fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1];
		}
	}
}