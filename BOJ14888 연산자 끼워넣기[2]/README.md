# [14888] 연산자 끼워넣기

## 분류
> 브루트포스
>
> 백트래킹

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888_2 {
    private static int N;
    private static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    private static int[] number, op;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        number = new int[N];
        op = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        calculate(number[0], 1);
        System.out.println(max + "\n" + min);
    }

    private static void calculate(int sum, int idx) {
        if (idx == N) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;
                switch (i) {
                    case 0:
                        calculate(sum + number[idx], idx + 1);
                        break;
                    case 1:
                        calculate(sum - number[idx], idx + 1);
                        break;
                    case 2:
                        calculate(sum * number[idx], idx + 1);
                        break;
                    case 3:
                        calculate(sum / number[idx], idx + 1);
                        break;
                }
                op[i]++;
            }
        }
    }
}
```

## 문제풀이

백트래킹인 것을 알고 풀었는데도 바로 생각해내진 못했다.

백트래킹에 집중하지 않고 전체 다 돌고 다시 도는 것에 집중했다.

반복문으로 모든 연산자가 첫번째가 되는 경우를 만들어주고, 내부에서 스위치문으로 재귀를 통해 풀었다.
첫번째 인자는 전체 합을, 두번째 인자는 숫자 인덱스를 나타냈다. 
op[i]--; 와 op[i]++이 이 문제의 핵심이다. 일단 시작한 재귀에서는 하나씩 줄여 방문 여부를 체크해주고, 스위치문을 모두 돌고나면 (재귀가 하나씩 빠질때마다) 방문했던 곳을 재방문해야하기 때문에 다시 ++로 표시해주었다.

백트래킹을 풀면서 항상 생각이 드는 것이지만, 너무 깊이 생각하고 더 복잡할 땐 어떻게 진행되는가를 떠올리면 어려워지는 듯하다. 이 문제도 단순히 연산자가 1개 이하씩 또는 숫자가 4개 이하일 때는 쉽게 흘러가는데 연산자와 숫자가 늘어나면 내가 작성한 코드가 맞는지 헷갈려서 재확인하다 보면 고민에 고민만 거듭하고 문제는 안풀렸던 것 같다..
