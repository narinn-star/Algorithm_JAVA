import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ2581 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		ArrayList<Integer> array = new ArrayList<>();
		
		for(int i = M; i <= N; i++) {
			if(isPrime(i)) {
				array.add(i);
			}
		}
		
		for(int i = 0; i < array.size(); i++) {
			sum += array.get(i);
		}
		
		if(array.size() > 0) {			
			System.out.println(sum);
			System.out.println(array.get(0));
		}
		else
			System.out.println("-1");
	}
	
	public static boolean isPrime(int M) {
		if(M == 1)
			return false;
		for(int i = 2; i < M; i++) {
			if(M % i == 0)
				return false;
		}
		return true;
	}

}
