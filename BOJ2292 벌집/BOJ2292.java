import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2292 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int i = 1;
		int cnt = 1;
		int tmp = 0;
		int x = 0;
		while(i < N) {
			tmp++;
			i++;
			if(tmp == 6 * (x+1) && (i - 1) % 6 == 0) {
				if(i == N)
					break;
				tmp = 0;
				cnt++;
				x++;
			}
		}
		if(N == 1)
			System.out.println(1);
		else
			System.out.println(cnt+1);
		
	}
}