import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ1620 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] name = new String[N + 1];
		
		HashMap<String, Integer> list = new HashMap<>(N + 1);
		for(int i = 1; i <= N; i++) {
			name[i] = br.readLine();
			list.put(name[i], i);
		}
		
		for(int i = 0; i < M; i++) {
			String input = br.readLine();
			try {
				double num = Double.parseDouble(input);
				System.out.println(name[Integer.parseInt(input)]);
			}catch(NumberFormatException e) {
				System.out.println(list.get(input));
			}
		}
	}
}