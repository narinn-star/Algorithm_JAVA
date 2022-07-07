import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1406 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> lStack = new Stack<>();
		Stack<Character> rStack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		for(int i = 0; i < str.length(); i++) {
			lStack.push(str.charAt(i));
		}
		
		int N = Integer.parseInt(br.readLine());
		
		while(N-- > 0) {
			String[] line = br.readLine().split(" ");
			switch(line[0]) {
			case "L":
				if(!lStack.empty())
					rStack.push(lStack.pop());
				break;
			case "D":
				if(!rStack.empty())
					lStack.push(rStack.pop());
				break;
			case "B":
				if(!lStack.empty())
					lStack.pop();
				break;
			case "P":
				lStack.push(line[1].charAt(0));
				break;
			}
		}

		while(!lStack.isEmpty())
			rStack.push(lStack.pop());
		
		while(!rStack.isEmpty())
			sb.append(rStack.pop());
		System.out.println(sb);
	}
}