import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ10773 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<>();
		int sum = 0;
		
		int K = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < K; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0)
				stack.pop();
			else
				stack.push(input);
		}
		
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		bw.write(sum + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}