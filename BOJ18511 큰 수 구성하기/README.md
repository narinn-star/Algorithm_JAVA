# [18511] 큰 수 구성하기

## 분류
> 브루트포스 알고리즘
>
> 재귀

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ18511 {
    private static int N, num, res, cnt = 0, now = 0;
    private static int[] K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        num = Integer.parseInt(st.nextToken());
        K = new int[num];

        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < num; i++) {
            K[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(K);
        findBig(0);
        System.out.println(res);
    }

    private static void findBig(int now){
        if(N < now) return;
        if(res < now) res = now;

        for(int i = 0; i < num; i++){
            findBig((now * 10) + K[i]);
        }
    }
}

```

## 문제풀이

하노이 탑 이동순서(11729)보다는 훨씬 수월하게 풀었다.
우선 배열을 하나씩 담아주고, 정렬까지 해주었다. 예시에서는 이미 정렬된 상태로 배열에 값을 넣어주지만, 뒤죽박죽인 채로 넣게되면 탐색하는데에 지장이 있기 때문이다. (사실 브루트포스인 것은 findBig함수를 구현할 때 쯤에야 눈치채고 정렬해주었다.)
그리고 나서 종료조건을 생각해보니, 이미 문제에 다 나와있었다. N보다 작은 수 중에 가장 큰 수를 찾는것이기 때문에 종료조건은 now가 N보다 커지는 순간 res에 넣지 않고 바로 탈출시켰다.
이제 해야할 일은 숫자를 붙여주는 것. N은 10 이상이라고 했지만 어차피.. 몇개 안될것 같기도 하고 시간에서 걸릴 것 같지 않아 그냥 1의 자리부터 계산해서 돌려버렸다.
처음엔 fingBig을 밖에 빼두고 for문의 i를 어떻게 해볼까.. 했는데 아무리 생각해봐도 그건 아닌 것 같고 해서 함수 호출 위치를 아예 for문으로 넣었더니 디버깅 과정에서는 수가 하염없이 커지다가도 어차피 return해서 그 전 함수 호출된 위치로 돌아가기 때문에 다시 숫자가 줄어드는 걸 보고 '아 이게 재귀였지'라는 것을 다시 알았다. 
재귀는 1-2문제 더 풀어볼 예정이다. 감을 잡아가는 것 같아서..ㅎ 
