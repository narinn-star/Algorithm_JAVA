import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1010 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double N = Double.parseDouble(st.nextToken());
			double M = Double.parseDouble(st.nextToken());
			double west = 1, east = 1;

				for (double i = M - N + 1; i <= M; i++) {
					east *= i;
				}
				for (double i = 1; i <= N; i++) {
					west *= i;
				}
				double res = east/west;
				System.out.printf("%.0f\n", res);
		}
	}

}
