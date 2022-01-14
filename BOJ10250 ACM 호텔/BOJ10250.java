import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10250 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			String[] data = br.readLine().split(" ");
			int H = Integer.parseInt(data[0]);
			int W = Integer.parseInt(data[1]);
			int N = Integer.parseInt(data[2]);
			
			int tmp = N % H;
			int result = 0;

			if(tmp == 0)
				result = (H * 100) + (N / H);
			else {
				result = ((tmp) * 100) + (N / H) + 1;
			}
			
			System.out.println(result);			
		}
		br.close();
	}
}