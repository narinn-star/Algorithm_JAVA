import java.util.Scanner;

public class BOJ3053 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double R = sc.nextDouble();
		
		System.out.println(R * R * Math.PI);
		System.out.println(2 * R * R);
		
		sc.close();
	}
}