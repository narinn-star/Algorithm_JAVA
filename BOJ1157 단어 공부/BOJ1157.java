import java.util.Scanner;

public class BOJ1157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int[] cnt = new int[26];
		int max = -1;
		int tmp = 0;
		char res = '?';
		String upper = str.toUpperCase();

		for (int i = 0; i < str.length(); i++) {
			tmp = (upper.charAt(i)) - 65;
			cnt[tmp]++;
		}

		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] > max) {
				max = cnt[i];
				res = (char) (i + 65);
			} else if (cnt[i] == max)
				res = '?';
		}

		System.out.println(res);

		sc.close();
	}
}