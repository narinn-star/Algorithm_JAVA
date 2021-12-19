import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11050 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().split(" ");
		int a = Integer.parseInt(line[0]);
		int b = Integer.parseInt(line[1]);
		int res1 = 1;
		int res2 = 1;
		
		for(int i = a; i > a - b; i--) {
			res1 *= i;
		}
		for(int i = b; i > 0; i--) {
			res2 *= i;
		}
		System.out.println(res1 / res2);
		br.close();
	}
}