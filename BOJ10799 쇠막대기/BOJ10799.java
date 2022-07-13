import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> stack = new Stack<>();
		
		String[] str = br.readLine().split("");
		int cnt = 0;
		for(int i = 0; i < str.length; i++) {
			if(str[i].equals("(")) {
				stack.push("(");
				continue;
			}
			if(str[i].equals(")")) {
				stack.pop();
				if(str[i-1].equals("(")) {
					cnt += stack.size();
				}
				else {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}