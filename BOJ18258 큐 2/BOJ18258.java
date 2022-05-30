import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18258 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Queue<Integer> queue = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine());
		int last = 0;
		
		while(N-- > 0) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			
			switch(order) {
			case"push":
				int x = Integer.parseInt(st.nextToken());
				last = x;
				queue.add(x);
				break;
			case"pop":
				if(queue.isEmpty()) sb.append(-1).append('\n');
				else sb.append(queue.poll()).append('\n');
				break;
			case"size":
				sb.append(queue.size()).append('\n');
				break;
			case"empty":
				if(queue.isEmpty()) sb.append(1).append('\n');
				else sb.append(0).append('\n');
				break;
			case"front":
				if(queue.isEmpty()) sb.append(-1).append('\n');
				else sb.append(queue.peek()).append('\n');
				break;
			case"back":
				if(queue.isEmpty()) sb.append(-1).append('\n');
				else sb.append(last).append('\n');
				break;
			}
		}
		System.out.println(sb);
	}
}