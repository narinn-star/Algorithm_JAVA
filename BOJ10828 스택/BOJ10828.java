import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		
		while(N-- > 0) {
			String[] order = br.readLine().split(" ");
			switch(order[0]) {
			case"push":
				stack.push(Integer.parseInt(order[1]));
				break;
			case"pop":
				if(stack.isEmpty())
					sb.append("-1").append("\n");
				else
					sb.append(stack.pop()).append("\n");
				break;
			case"size":
				sb.append(stack.size()).append("\n");
				break;
			case"empty":
				if(stack.isEmpty())
					sb.append("1").append("\n");
				else
					sb.append("0").append("\n");
				break;
			case"top":
				if(stack.isEmpty())
					sb.append("-1").append("\n");
				else
					sb.append(stack.peek()).append("\n");
				break;
			}
		}
		System.out.print(sb);
	}
}