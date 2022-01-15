import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1193 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		
		int line = 1;
		int cnt = 0;
		
		while(true) {
			if(X <= cnt + line) {
				if(line % 2 == 0) {
					System.out.println((X - cnt) + "/" + (line - (X - cnt - 1)));
				}
				else
					System.out.println((line - (X - cnt - 1)) + "/" + (X - cnt));
				break;
			}
			else {
				cnt += line;
				line++;
			}
		}
		
	}

}
