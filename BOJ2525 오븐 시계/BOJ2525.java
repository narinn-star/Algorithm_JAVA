import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2525 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int C = Integer.parseInt(br.readLine());

		B += C;
		int D = C / 60;
		for (int i = 0; i <= D; i++) {
			if (B > 59) {
				A++;
				B = B - 60;
			}
		}
		if (A > 23) {
			A = A - 24;
		}
		System.out.println(Math.abs(A) + " " + Math.abs(B));
	}
}