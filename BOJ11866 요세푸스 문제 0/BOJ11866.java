import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ11866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		sb.append("<");
		
		String[] str = new String[2];
		str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
				
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		while(true) {
			int cnt = 1;

			if(queue.size() == 1)
				break;
			
			while(cnt < K) {
				int q = queue.poll();
				queue.add(q);
				cnt++;
			}
			
			if(cnt == K) {
				sb.append(queue.poll()).append(", ");
			}
		}
		sb.append(queue.poll()).append(">");
		System.out.println(sb);
	}
}