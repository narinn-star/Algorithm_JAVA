# [7568] 덩치

## 분류
> 구현
>
> 브루트포스 알고리즘

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int person[][] = new int[N][2];
        int score[] = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            person[i][0] = Integer.parseInt(st.nextToken());
            person[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (person[i][0] < person[j][0] && person[i][1] < person[j][1]) {
                    score[i]++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(score[i] + 1);
        }

    }
}
```

## 문제풀이

벌써 세 번째 푼 문제. 
브루트포스 알고리즘의 대표적인 문제라 해도 될듯하다. 완전 탐색 말 그대로 실행하고 있는 듯하다.

1. 덩치 비교하기
2. 등수 정하기

1. 덩치는 몸무게와 키 모두 비교해 둘 다 커야 덩치가 크다고 판별된다. 2차원 배열에 몸무게/키를 담아 하나씩 비교했다.
2. 등수는 덩치가 작은 사람이 +1 되기때문에 덩치가 작다고 판별될 때 score 배열의 해당 사람 인덱스 값을 +1 해주었다.

마지막 출력은 초기에 score 배열을 1로 해두는 대신 +1씩 해준 후 출력했다.

+ 풀이를 쓰면서 발견했는데, 자기 자신과는 비교할 필요가 없으므로 
`if(i == j) continue;`
라는 코드를 추가하면 더 효율적일 것 같다!

위 코드에서 오류가나지 않는 이유는 비교조건에 전혀 위배되지 않기 때문이긴 하다.
