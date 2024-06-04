# [14244] 트리 만들기

## 분류
> 트리
>
> 해 구성하기

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ14244 {
    private static int N, M;
    private static ArrayList<Integer> tree[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N];
        for(int i = 0; i < N; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i = 1; i <= M; i++){
            tree[0].add(i);
            System.out.println(0 + " " + i);
        }

        for(int i = M + 1; i < N; i++){
            tree[i - M].add(i);
            System.out.println(i - M + " " + i);
        }
    }
}

```

## 문제풀이

트리의 리프 노드가 M개가 되도록 트리를 구성하는 문제다.

만약 노드 개수가 10개, 리프 노드가 3개라면 애초에 루트 노드의 자식 노드를 3개로 만들어두면 아무리 노드 개수가 많아져도 리프 노드를 3개로 유지할 수 있다. 
그래서 루트는 0으로 잡아두고, 리프 노드만큼 루트의 자식 노드를 배정해준 뒤, 인덱스를 적절히 조절해서 그 자식 노드들에게 하나씩 자식 노드를 만들어주면 된다.

ArrayList 출력을 반복문으로 다시 해주려다가 ArrayList에 넣음과 동시에 출력을 해줬다.
생각해보니 ArrayList 필요도 없이 그냥 출력만 하면.. 되는 문제였다.
