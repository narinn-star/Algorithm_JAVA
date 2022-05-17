import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ17219 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> password = new HashMap<>(N);
		
		for(int i = 0; i < N; i++) {

				String[] str = br.readLine().split(" ");
				password.put(str[0], str[1]);

		}
		
		for(int i = 0; i < M; i++) {
			bw.write(password.get(br.readLine()) + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}