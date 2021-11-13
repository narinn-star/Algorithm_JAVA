import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ2609 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = 0;
		int max = Integer.MIN_VALUE;

		if (a >= b)
			c = b;
		else
			c = a;

		for (int i = 1; i <= c; i++) {
			if (a % i == 0 && b % i == 0) {
				max = Math.max(max, i);
			}
		}
		
		bw.write(max + "\n");
		bw.write((a * b / max) + "\n");

		bw.flush();
		bw.close();
		br.close();

	}
}