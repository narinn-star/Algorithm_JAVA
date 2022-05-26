import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		sb.append("<");
		while (!(queue.isEmpty())) {
			for (int i = 1; i <= K; i++) {
				if (i == K) {
					sb.append(queue.poll());
					if (queue.size() > 0)
						sb.append(", ");
				} else
					queue.add(queue.poll());
			}
		}
		sb.append(">");
		System.out.println(sb);
	}
}