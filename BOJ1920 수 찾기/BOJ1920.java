import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		
		int M = Integer.parseInt(br.readLine());
		int [] B = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		int res = 0;
		for(int i = 0; i < M; i++) {
			res = bSearch(A, B[i]);
			bw.write(res + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int bSearch(int[] A, int b) {
		int low = 0;// A의 왼쪽 끝 인덱스
		int high = A.length - 1;	//A의 오른쪽 끝 인덱스
		
		while(low <= high) {
			int mid = (low + high) / 2;
			if(A[mid] == b)
				return 1;
			else if(A[mid] > b)
				high = mid -1;
			else
				low = mid + 1;
		}
		return 0;
	}
}