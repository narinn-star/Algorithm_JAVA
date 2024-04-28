# [2805] 나무 자르기

## 분류
> 이분 탐색
>
> 매개 변수 탐색

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] tree = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tree);

        int low = 0, high = tree[N-1];

        while(low < high){
            long sum = 0;
            int mid = (low + high) / 2;

            for(int i = 0; i < N; i++){
                if(tree[i] - mid > 0) sum += (tree[i] - mid);
            }

            if(sum >= M){
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        System.out.println(low - 1);
    }
}
```

## 문제풀이

2년만에 풀어본 이분탐색 문제

얼마 전에 릿코드로 기본적인 것을 봐서 정렬, 반복문 탈출 조건 정도는 익히고 있었지만 답이 생각보다 명확하게 나오지 않아서 당황했다. 분명히 잘 쪼개어서 중간값도 찾아주고 했다고 생각했는데, 반례들을 찾아보니 다 틀리게 나오는 것...... 

알고 보니 sum > M 이 부분이 문제였는데, UpperBound 방식과 LowerBound 방식 두가지가 있어서 두가지를 다른 방식으로 답을 출력해야했다. 나는 sum >= M , UpperBound 방식을 선택해 탈출 전에 low = mid + 1이 되어 있어 1을 빼주면서 출력해줘야했다.

내일 UpperBound LowerBound에 대해 더 자세히 알아봐야겠샴..... 2년 전에도 똑같이 이랬던데 왜 남은 것이 없는가😰
