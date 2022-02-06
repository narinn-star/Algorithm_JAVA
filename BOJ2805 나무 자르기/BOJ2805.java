import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2805 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int max = 0;
		int min = 0;

		int[] tree = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());

			if (tree[i] > max) 				// 가장 높은 나무 찾기
				max = tree[i];
		}

		while (min < max) {
			int mid = (min + max) / 2;
			long sum = 0; 					// 최대 높이가 1,000,000,000이므로 합을 구하면 long타입이 필요

			for (int h : tree) {
				if(h - mid > 0)				//0, 음수일 때는 제외
					sum += (h - mid);
			}
			
			if(sum < M)
				max = mid;
			else
				min = mid + 1;
		}
		System.out.println(min - 1);
	}
}