import java.math.BigInteger;
import java.util.Scanner;

public class BOJ13706 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BigInteger N = sc.nextBigInteger();
		BigInteger start = new BigInteger("1");
		BigInteger end = N;
		BigInteger mid;
		
		while(true) {
			mid = start.add(end);
			mid = mid.divide(new BigInteger("2"));
			
			int res = (mid.multiply(mid)).compareTo(N);
			if(res == 0) break;
			else if(res == 1)
				end = mid.subtract(new BigInteger("1"));
			else
				start = mid.add(new BigInteger("1"));
		}
		
		System.out.println(mid.toString());
		sc.close();
	}
}