import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10815 {
	static int N;
	static int[] num;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int card = Integer.parseInt(st.nextToken());
			if(binary(card))
				sb.append("1").append(" ");
			else
				sb.append("0").append(" ");
		}
		System.out.print(sb);
	}
	private static boolean binary(int n) {
		int front = 0;
		int last = N - 1;
		
		while(front <= last) {
			int idx = (front + last)/2;
			int mid = num[idx];
			
			if(n < mid) last = idx - 1;
			else if(n > mid) front = idx + 1;
			else return true;
		}
		return false;
	}
}