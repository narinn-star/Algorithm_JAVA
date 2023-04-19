# [15650] N과 M (2)

## 분류
> 백트래킹

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15650 {
    static int N, M;
    static int[] res;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        res = new int[M + 1];

        func(1, 0);

        System.out.println(sb);
    }

    private static void func(int start, int num) {
        if(num == M){
            for(int i = 0; i < M; i++){
                sb.append(res[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i <= N; i++){
            res[num] = i;
            func(i + 1, num + 1);
        }
    }
}
```

## 문제풀이

N과 M(1)과 '오름차순 정렬'인것만 빼면 똑같은 문제이다.
하지만 이 오름차순 정렬이라는 조건 덕분에(?) 로직은 조금 더 간단해졌다. visited 배열이 따로 필요없기 때문이다. 돌아오지 않고 수열을 구성하면 오름차순은 당연히 완성되는 것이고, 재귀호출할 때 인자값만 잘 넘겨주면 1번과 똑같은 문제이다.
이 문제에서는 트리 깊이를 계산해주기 위해 num, 그리고 값들을 넣을 start 두개를 넘겨줬다.

func(start + 1, num + 1); 
위와 같이 호출하려 했는데, 이렇게 하면 1 2 부터 1 4까지는 정상적으로 출력되지만, start값이 문제가 원하는대로 변하지 않기 때문에 i + 1로 하나 증가시켜 호출해야한다.

