import java.util.Scanner;

public class BOJ1789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        long sum = 0;
        int cnt = 0;

        if(N == 1) {
            System.out.println(1);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (sum > N) break;
            sum += i;
            cnt++;
        }

        System.out.println(cnt - 1);
    }
}
