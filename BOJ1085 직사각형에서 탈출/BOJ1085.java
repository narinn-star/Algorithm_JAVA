import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1085 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] str = br.readLine().split(" ");
		
		int min = 1001;
		int x = Integer.parseInt(str[0]);
		int y = Integer.parseInt(str[1]);
		int w = Integer.parseInt(str[2]);
		int h = Integer.parseInt(str[3]);
		
		min = Math.min(min, Math.abs(x-w));
		min = Math.min(min, Math.abs(y-0));
		min = Math.min(min, Math.abs(y-h));
		min = Math.min(min, Math.abs(x-0));
	
		bw.write(min + "");
		bw.flush();
		bw.close();
		br.close();
	}
}