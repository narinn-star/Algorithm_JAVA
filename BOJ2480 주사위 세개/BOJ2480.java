import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2480 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] a = new int[3];
		int res = 0;
		
		for(int i = 0; i < 3; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		if(a[0] == a[1] && a[1] == a[2]) {
			res = 10000 + a[0] * 1000;
		}
		if(a[0] == a[1] && a[0] != a[2]) {
			res = 1000 + a[0] * 100;
		}
		if(a[0] == a[2] && a[0] != a[1]) {
			res = 1000 + a[0] * 100;
		}
		if(a[1] == a[2] && a[1] != a[0]) {
			res = 1000 + a[1] * 100;
		}
		if(a[0] != a[1] && a[1] != a[2] && a[0] != a[2]) {
			Arrays.sort(a);
			res = a[2] * 100;
		}
		System.out.println(res);
	}
}