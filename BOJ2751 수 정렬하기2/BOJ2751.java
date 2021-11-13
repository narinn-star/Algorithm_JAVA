import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BOJ2751 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());

		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(br.readLine())) ;
		}
		
		Collections.sort(arr);
		
		for(int val : arr) {
			bw.write(val + "\n"); 
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}