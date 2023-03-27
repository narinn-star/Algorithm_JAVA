import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11729 {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        sb.append((int)Math.pow(2, N) -1 + "\n"); //점화식

        hanoi(1, 2, 3, N);
        System.out.println(sb);
    }

    private static void hanoi(int A, int mid, int B, int N) { //A : 출발, mid : 경유, B : 도착
        if (N == 1) { //탈출 조건
            sb.append(A + " " + B + "\n"); //
            return;
        }

        //일단 첫번째 원판에서 두번째로 하나빼고 다 옮겨! (경유)
        hanoi(A, B, mid, N - 1);  // N-1

        // 그러면 첫번째 원판에 하나 남겠찌? 그거 세번째로 옮겨! (도착!)
        sb.append(A + " " + B + "\n");

        //이제 두번째 원판꺼 세번째 원판으로 다 옮겨!
        hanoi(mid, A, B, N - 1);
    }
}
