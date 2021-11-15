import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2839 {
	static int cnt, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		
		if(N == 4 || N == 7)
			bw.write("-1");
		else if (N % 5 == 0)
			bw.write(N / 5 + "\n");
		else if (N % 5 == 1 || N % 5 == 3)
			bw.write((N / 5) + 1 + "\n");
		else if (N % 5 == 2 || N % 5 == 4)
			bw.write((N / 5) + 2 + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}