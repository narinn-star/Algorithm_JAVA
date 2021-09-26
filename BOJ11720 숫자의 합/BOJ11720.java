import java.util.Scanner;

public class BOJ11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String str = sc.next();
		int s = 0;
		
		for(int i = 0; i < N; i++) {
			char ch = str.charAt(i);
			s += (int)ch - '0';
		}
		System.out.println(s);
		sc.close();
	}
}