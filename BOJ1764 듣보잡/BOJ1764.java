import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ1764 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<String> list = new ArrayList<>();
		HashSet<String> set = new HashSet<>();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		
		for(int i = 0; i < M; i++) {
			String name = br.readLine();
			if(set.contains(name)) {
				list.add(name);
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		for(String s : list) {
			System.out.println(s);
		}
		br.close();
	}
}