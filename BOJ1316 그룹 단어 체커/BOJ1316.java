import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;;

public class BOJ1316 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		String[]str = new String[N];
		
		for(int i = 0; i < N; i++) {
			str[i] = br.readLine();
		}
		
		for(int i = 0; i < N; i++) {
			boolean[] check = new boolean[26];
			boolean ch = true;
			int tmp = 0;
			for(int j = 0; j < str[i].length(); j++) {
				int now = str[i].charAt(j);
				
				if(tmp != now) {
					if(check[now-'a'] == false) {
						check[now-'a'] = true;
						tmp = now;
					}
					else {
						ch = false;
						break;
					}
				}
			}
			if(ch)
				cnt++;
		}
		
		
		System.out.println(cnt);
	}
}