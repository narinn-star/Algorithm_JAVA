import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17413 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb;
		String[] str = br.readLine().split("<");
		
		for(int i = 0; i < str.length; i++) {
			if(str[i].charAt(0) == '<')
				continue;
			else {
				sb = new StringBuffer();
				sb.append(str[i]).reverse();
			}
			System.out.print(sb);
		}
		
	}
}