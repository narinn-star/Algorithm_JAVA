import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11558 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N+1];
			boolean[] visited = new boolean[N+1];
			
			int flag = -1;

			int cnt = 0, tmp = 1;
			
			for(int j = 1; j <= N; j++) {
				arr[j] = Integer.parseInt(br.readLine());
			}
			
			while(!visited[tmp]) {
				visited[tmp] = true;
				
				if(tmp == N) {
					flag = 1;
					break;
				}			
				tmp = arr[tmp];
				cnt++;
			}
	         System.out.println(flag == 1?cnt:0);
	      }
		br.close();
	}

}