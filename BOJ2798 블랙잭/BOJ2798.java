import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ2798 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] card = new int[N];
		int sum = 0, tmp = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 0; i < N-2; i++) {
			for(int j = i + 1; j < N-1; j++) {
				for(int k = j + 1; k < N; k++) {
					tmp = card[i] + card[j] + card[k];
					if(tmp == M)
						sum = tmp;
					
					if(sum < tmp && tmp < M)
						sum = tmp;
				}
			}
		}

		bw.write(sum + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}