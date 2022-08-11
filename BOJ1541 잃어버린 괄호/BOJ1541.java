import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sub = br.readLine().split("-");
		
		int sum = Integer.MAX_VALUE;
		
		for(int i = 0; i < sub.length; i++) {
			int tmp = 0;
			String[] add = sub[i].split("\\+");
			
			for(int j = 0; j < add.length; j++) {
				tmp += Integer.parseInt(add[j]);
			}
			
			if(sum == Integer.MAX_VALUE) {
				sum = tmp;
			}
			else {
				sum -= tmp;
			}
		}
		System.out.println(sum);			
	}
}