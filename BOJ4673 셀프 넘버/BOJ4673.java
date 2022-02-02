public class BOJ4673 {
	public static void main(String[] args) {
		boolean[] number = new boolean[10001];
		
		for(int i = 1; i < 10001; i++) {
			int n = div(i);
			
			if(n < 10001)
				number[n] = true;
		}
		
		for(int i = 1; i < 10001; i++) {
			if(number[i] == false)
				System.out.println(i);
		}
	}
	
	public static int div(int n) {
		int sum = n;
		
		while(n != 0) {
			sum = sum + (n % 10);		//첫째자리수 뽑고
			n = n / 10;					//첫째자리수 없애기
		}
		return sum;
	}
}