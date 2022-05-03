import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ7568 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] weight = new int[N + 1];
		int[] height = new int[N + 1];
		int[] cnt = new int[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			height[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (weight[i] < weight[j] && height[i] < height[j]) {
					cnt[i]++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			System.out.print(cnt[i] + 1 + " ");
		}
	}
}