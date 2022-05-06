import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9461 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long[] arr = new long[102];
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		
		for (int i = 4; i <= 100; i++) {
			arr[i] = arr[i - 3] + arr[i - 2];
		}

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(arr[N]);
		}
	}
}