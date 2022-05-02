import java.util.Scanner;

public class BOJ1065 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int cnt = 0;

		if (N < 100) {
			System.out.println(N);
		} else {
			cnt = 99;

			for (int i = 110; i <= N; i++) {
				int hun = i / 100; // 2
				int ten = (i % 100) / 10; // 1
				int one = ((i % 100) % 10);	// 0
				
				if(hun - ten == ten - one) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
		sc.close();
	}
}