# [11729] 하노이 탑 이동 순서

## 분류
> 재귀

## 코드
```java
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

```

## 문제풀이

첫 접근이 잘못됐다. 애초에 하노이 탑 자체를 진짜 옮겨버리겠다는 생각으로 스택이며 원판 갯수며 첫 이동부터 두번째 칸으로 하느냐 세번째 칸으로 하느냐 거기에 이동 횟수는 최소로 해야하며... 이 모든걸 생각하려고 하니 당연히 될 리가 있나. 거기다 이 문제는 애초에 재귀 문제라는 것을 알고 시작했기 때문에 '재귀'에 또 발이 묶여 이걸 어떻게 재귀로 풀란 말이냐. 하면서 혼자 끙끙거렸다.
그래서 '재귀'에 대해서만 생각해보기로 했다. 그저 재귀를 감싼 문제일 뿐이라 생각하며..
재귀는 첫째, 종료조건에 걸릴 때까지 계속한다. 둘째, 규칙을 찾는다.
바로 규칙 찾기에 들어갔다. (냅다 세었다.)

원판이 하나일 때 -> 1번
원판이 두개일 때 -> 3번
원판이 세개일 때 -> 7번
원판이 네개일 때 -> 15번
...
더 세어볼까 하다가 멈췄다. 딱봐도 <b>2에n제곱 -1</b> 인것이 보여서!! 그럼 최소 이동 횟수는 해결했다.

이제 이동 순서를 출력하는 점이다. (사실 이게 된 게 신기.. 그래서 내일 찬찬히 다시 뜯어보려한다.)
우선 내가 푼 방식은 아래와 같다.

가장 오른쪽으로 옮기기 위해 첫번째로 해결해야하는 것은 가장 큰 원판을 옮겨두는 것이다. 그래야 위에 작은 원판들을 하나씩 차례로 올릴 수 있기 때문. 

1. 그럼 가장 큰 원판을 옮기기 전에는 당연히 모든 원판이 두번째 칸에 옮겨져 있어야 한다. 
2. 가장 큰 원판을 세번째 칸으로 옮긴다.
3. 두번째 칸에 있던 원판들을 모두 세번째 칸으로 옮긴다.

...일단 끝!

잔디 test
