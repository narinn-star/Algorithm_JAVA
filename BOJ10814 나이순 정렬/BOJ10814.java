import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ10814 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String[][] str = new String[N][2];
		
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			str[i][0] = s[0];
			str[i][1] = s[1];
		}
		
		Arrays.sort(str, new Comparator<String[]>() {
			public int compare(String[] s1, String[] s2) {
				return (Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]));
			}
		});
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 2; j++) {
				bw.write(str[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}