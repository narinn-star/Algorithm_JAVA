import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1904 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N + 2];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		if (N == 1 || N == 2) {
			System.out.println(dp[N]);
			return;
		} else {
			for (int i = 3; i <= N; i++) {
				dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
			}

			System.out.println(dp[N]);
		}
	}
}