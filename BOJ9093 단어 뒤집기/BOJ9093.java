import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9093 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb;
		StringBuffer print = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			String[] str = br.readLine().split(" ");
			
			for(int i = 0; i < str.length; i++) {
				sb = new StringBuffer();
				sb.append(str[i]);
				sb.reverse();
				print.append(sb).append(" ");
			}
			print.append("\n");
		}
		System.out.println(print);
	}
}