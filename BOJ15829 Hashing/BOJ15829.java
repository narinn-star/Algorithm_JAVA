import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15829 {
	static int M = 1234567891;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		String str = br.readLine();
		long pow = 1;
		long hash = 0;
		
		for(int i = 0; i < L; i++) {
			hash += (str.charAt(i) - 'a' + 1) * pow % M;
			pow = pow * 31 % M;
		}
		System.out.println(hash % M);
	}
}