import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String asc = "1 2 3 4 5 6 7 8";
		String dsc = "8 7 6 5 4 3 2 1";
		
		String input = br.readLine();
		if(input.equals(asc)) {
			bw.write("ascending");
		}
		else if(input.equals(dsc)) {
			bw.write("decending");
		}
		else {
			bw.write("mixed");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}