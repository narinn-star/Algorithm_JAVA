import java.util.Scanner;

public class BOJ2775 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 }; // 호수
			int res = 0;

			if (n == 1)
				res = arr[0];
			else {
				for (int j = 0; j < k; j++) {
					for (int l = 1; l < arr.length; l++) {
						arr[l] = arr[l - 1] + arr[l];
						res = arr[n - 1];
					}
				}
			}
			System.out.println(res);
		}
		sc.close();
	}
}
