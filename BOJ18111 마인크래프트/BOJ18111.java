import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ18111 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int B = Integer.parseInt(input[2]);
		int[][] ground = new int[N][M];

		int min = Integer.MAX_VALUE;
		int max = 0;

		int sec = Integer.MAX_VALUE, height = -1;

		for (int i = 0; i < N; i++) {
			String[] row = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				ground[i][j] = Integer.parseInt(row[j]);

				max = Math.max(max, ground[i][j]);
				min = Math.min(min, ground[i][j]);
			}
		}

		for (int k = min; k <= max; k++) {
			int t = 0;
			int block = B;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					int dif = ground[i][j] - k;
					
					if(dif > 0) {
						t += Math.abs(dif) * 2;
						block += Math.abs(dif);
					}else if(dif < 0) {
						t += Math.abs(dif);
						block -= Math.abs(dif);
					}
				}
			}
			if(block < 0)
				continue;
			if(sec >= t) {
				sec = t;
				height = k;
			}
		}
		System.out.println(sec + " " + height);
	}
}