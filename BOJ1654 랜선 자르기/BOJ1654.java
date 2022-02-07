import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] kLine = new int[K];
		long max = 0, mid = 0, min = 0;
		
		for(int i = 0; i < K; i++) {
			kLine[i] = Integer.parseInt(br.readLine());
			if(max < kLine[i])
				max = kLine[i];
		}
		
		max++;									//0으로 나누어지는 것을 방지
		
		while(min < max) {
			mid = (min + max) / 2;
			long cnt = 0;
			
			for(int i = 0; i < kLine.length; i++) {
				cnt += (kLine[i] / mid);
			}
			
			if(cnt < N) 
				max = mid;
			else
				min = mid + 1;
		}
		
		System.out.println(min - 1);
	}
}