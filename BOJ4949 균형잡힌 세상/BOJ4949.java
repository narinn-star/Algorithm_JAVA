import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = br.readLine();
			if(str.charAt(0) == '.')
				break;
			System.out.println(func(str));		
		}
	}
	
	static public String func(String str) {	
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c == '(' || c == '[')
				stack.push(c);
			else if(c == ')') {
				if(stack.empty() || stack.peek() != '(') {
					return "no";
				}		
				else
					stack.pop();
			}
			else if(c == ']') {
				if(stack.empty() || stack.peek() != '[') {
					return "no";
				}
				else
					stack.pop();
			}	
		}
		
		if(stack.isEmpty())
			return "yes";
		else
			return "no";
	}
}