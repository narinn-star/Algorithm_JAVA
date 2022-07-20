import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10820 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = "";
		while ((str = br.readLine()) != null) {
			int small = 0, big = 0, num = 0, space = 0;

			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c >= 'a' && c <= 'z')	small++;
				if (c >= 'A' && c <= 'Z')	big++;
				if (c >= '0' && c <= '9')	num++;
				if (c == ' ')	space++;
			}
			System.out.println(small + " " + big + " " + num + " " + space);
		}
	}
}