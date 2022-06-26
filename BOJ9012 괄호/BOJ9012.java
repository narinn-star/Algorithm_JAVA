import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		boolean check;
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			String[] input = br.readLine().split("");
			Stack<Integer> stack = new Stack<>();
			check = true;
			
			for(int i = 0; i < input.length; i++) {
				if(input[i].equals("(")) {
					stack.push(1);
				}
				else if(input[i].equals(")")){
					if(stack.isEmpty()|| stack.peek() == null) {
						check = false;
						break;
					}
					else {
						stack.pop();
					}
				}
			}
			if(!stack.isEmpty())
				check = false;
			
			if(check) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}
		System.out.println(sb);
	}
}