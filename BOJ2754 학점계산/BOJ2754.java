import java.util.Scanner;

public class BOJ2754 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String grade = sc.next();
		double score = 0;

		switch (grade.charAt(0)) {
		case 'A':
			score = 4;
			break;
		case 'B':
			score = 3;
			break;
		case 'C':
			score = 2;
			break;
		case 'D':
			score = 1;
			break;
		case 'F':
			score = 0;
		}
		if (grade.length() > 1) {
			switch (grade.charAt(1)) {
			case '+':
				score += 0.3;
				break;
			case '-':
				score -= 0.3;
				break;
			}
		}

		System.out.println(score);
		sc.close();
	}
}