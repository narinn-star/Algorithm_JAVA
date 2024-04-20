# [1946] 신입 사원

## 분류
> 그리디 알고리즘
>
> 정렬

## 코드
```java
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] rank = new int[N][2];
            int cnt = 1;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                rank[i][0] = Integer.parseInt(st.nextToken());
                rank[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(rank, (o1, o2) -> o1[0] - o2[0]); // 오름차순

            int tmp = rank[0][1];

            for (int i = 1; i < N; i++) {
                if (tmp > rank[i][1]) { 
                    tmp = rank[i][1];
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
```

## 문제풀이

이중 for문을 사용하니 바로 시간초과가 나서, 비교하는 rank 둘 중 하나를 변수로 두고 계속 바꿔주는 방식은 없을까에 대해 계속 생각하다, 면접 성적을 계속해서 최소값으로 갱신해주자는 생각이 들었다. 어차피 서류 심사 성적이 오름차순으로 되어있기 때문에, 면접 성적만 비교해주면 되기도 하고 면접 성적이 낮아지면 앞의 지원자보다 무조건 두개모두 낮은것이 되기 때문에, 다시 앞으로 돌아가서 전체를 다 탐색해줄 필요가 없다.
그리고 정렬했을 때 서류가 1등인 사람은 면접이 꼴등이어도 서류 1등으로 바로 합격할 수 있기 때문에 cnt값은 1부터 시작하며, 서류가 1등인 사람의 면접 등수를 최소 등수로 잡아두고 비교를 시작하면 된다.

