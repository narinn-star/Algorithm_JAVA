import java.util.Scanner;

public class BOJ2941 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String input = sc.nextLine();
		int cnt = 0;

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);

			if (ch == 'c') {
				if (i < input.length() - 1) {
					if (input.charAt(i + 1) == '=')
						i++;
					else if (input.charAt(i + 1) == '-')
						i++;
				}
			}

			else if (ch == 'd') {
				if (i < input.length() - 1) {
					if (input.charAt(i + 1) == 'z') {
						if (i < input.length() - 2) {
							if (input.charAt(i + 2) == '=')
								i = i + 2;
						}
					} else if (input.charAt(i + 1) == '-')
						i++;
				}
			}

			else if (ch == 'l') {
				if (i < input.length() - 1) {
					if (input.charAt(i + 1) == 'j')
						i++;
				}
			}

			else if (ch == 'n') {
				if (i < input.length() - 1) {
					if (input.charAt(i + 1) == 'j')
						i++;
				}
			}

			else if (ch == 's') {
				if (i < input.length() - 1) {
					if (input.charAt(i + 1) == '=')
						i++;
				}
			}

			else if (ch == 'z') {
				if (i < input.length() - 1) {
					if (input.charAt(i + 1) == '=')
						i++;
				}
			}
			cnt++;
		}

		System.out.println(cnt);
		sc.close();
	}

}
