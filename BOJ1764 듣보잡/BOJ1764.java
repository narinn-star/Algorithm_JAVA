import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1764 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] n = new String[N];
		String[] m = new String[M];
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			n[i] = br.readLine();
		}
		for(int i = 0; i < M; i++) {
			m[i] = br.readLine();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(n[i].equals(m[j])) {
					cnt++;
					sb.append(n[i]).append("\n");
				}
			}
		}
		System.out.println(cnt);
		System.out.println(sb);
		
	}
}
