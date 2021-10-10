import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2908 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		
		String[] str = br.readLine().split(" ");
		sb1.append(str[0]);
		sb2.append(str[1]);
		String str1 = sb1.reverse().toString();
		String str2 = sb2.reverse().toString();
		
		if(Integer.parseInt(str1) > Integer.parseInt(str2))
			bw.write(str1);
		else
			bw.write(str2);
		
		bw.flush();
		bw.close();
		br.close();
	}
}