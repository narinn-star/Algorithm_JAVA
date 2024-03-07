import java.io.IOException;
import java.util.Scanner;

public class BOJ1436 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int a = 666;
        int cnt = 1;

        while (cnt < N) {
            a++;
            if (String.valueOf(a).contains("666")) cnt++;
        }
        System.out.println(a);

        sc.close();
    }
}
