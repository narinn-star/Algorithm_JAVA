import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ10809 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] res = new int[26];
		Arrays.fill(res, -1);
		
		String str = br.readLine();
		
		for(int i = 0; i < str.length(); i++) {
			char alphabet = str.charAt(i);
			int a = alphabet - 'a';
			if(res[a] == -1)
				res[a] = i;
		}
		
		for(int i = 0; i < res.length; i++) {
			bw.write(res[i] + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}