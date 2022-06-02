import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9020 {
	public static boolean[] prime = new boolean[10001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			Prime();
			int a = n/2, b = n/2;
			
			while(true) {
				if(!prime[a] && !prime[b]) {
					System.out.println(a + " " + b);
					break;
				}
				a--;
				b++;
			}
		}
	}
	
	public static void Prime() {
		prime[0] = prime[1] = true;
 
		for (int i = 2; i < Math.sqrt(prime.length) + 1; i++) {
			if (prime[i])
				continue;
			for (int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
	}
}