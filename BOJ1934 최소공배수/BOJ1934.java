import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1934 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			String[] input = br.readLine().split(" ");
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);

			int d = gcd(A, B);

			sb.append(A * B / d).append("\n");
		}
		System.out.println(sb);
	}

	public static int gcd(int A, int B) {
		while (B != 0) {
			int r = A % B;

			A = B;
			B = r;
		}
		return A;
	}
}