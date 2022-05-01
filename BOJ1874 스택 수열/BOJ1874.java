import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();

		int n = Integer.parseInt(br.readLine());

		int last = 0;
		
		while(n-- > 0) {
			int val = Integer.parseInt(br.readLine());
			
			if(val > last) {
				for(int i = last + 1; i <= val; i++) {
					stack.push(i);
					sb.append('+').append("\n");
				}
				last = val;
			}
			else if(stack.peek() != val) {
				sb.delete(0, sb.length());
				sb.append("NO");
				break;
			}
			stack.pop();
			sb.append('-').append('\n');
		}
		System.out.println(sb);
	}
}