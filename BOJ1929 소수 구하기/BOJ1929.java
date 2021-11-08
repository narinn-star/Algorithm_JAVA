import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1929 {
	static boolean[] prime;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		prime = new boolean[M + 1];
		notPrime();

		for (int i = N; i <= M; i++) {
			if(!prime[i])
				bw.write(i + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	static public void notPrime() {
		prime[0] = prime[1] = true;

		for (int i = 2; i <= Math.sqrt(prime.length); i++) {
			for (int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
	}
}