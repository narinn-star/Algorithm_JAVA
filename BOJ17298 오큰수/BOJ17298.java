import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ17298 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		int[] res = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = N - 1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek() <= arr[i]) {
				stack.pop();
			}
			if (stack.isEmpty())
				res[i] = -1;
			else
				res[i] = stack.peek();

			stack.push(arr[i]);
		}

		for (int i = 0; i < N; i++) {
			sb.append(res[i] + " ");
		}
		System.out.println(sb);
	}
}