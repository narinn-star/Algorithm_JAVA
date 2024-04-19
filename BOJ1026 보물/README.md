# [1026] 보물

## 분류
> 수학
>
> 그리디 알고리즘
>
> 정렬

## 코드
```java
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < A.length; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < B.length; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> b = new ArrayList<>();
        for(int i = 0; i < B.length; i++){
            b.add(B[i]);
        }

        int res = 0;
        for(int i = 0; i < N; i++){
            int max = Collections.max(b);
            res += (A[i] * max);
            b.remove(Integer.valueOf(max));
        }

        bw.write(res + "\n");
        bw.flush();
        bw.close();
        br.close();

    }
}

```

## 문제풀이

B는 정렬을 하지 마라고 문제에 명시되어 있는데 다들 그냥 냅다 정렬해서 풀었더라.. 나도 당연히 그 방법을 가장 먼저 떠올리긴 했지만, 문제에서 하지 마라고 하니까 또 괜히 나는 다르게 풀고싶긴 했다😅

그래서 생각해낸 방법 첫번째가 인덱스를 붙이는 거였는데, 인덱스 붙이는 데에도 시간이 상당히 소요되고, 다시 알맞은 인덱스랑 곱해서 더하는 시간도 생각하니 말이 안되는 것 같아서 그만뒀다.
찾아보니 List에서 max값을 찾을 수 있는 방법이 있어서 그 방법을 사용했다. List에 값들을 넣어주고, Collections.max()로 최댓값을 뽑아준 뒤, List에서 해당 값은 지워줬다.

이게.. 맞겠지..? 구글에도 다들 정렬해서 풀어서 진짜 방법을 모르겠긴 한데.. 일단 정렬은 안했으니까 문제 의도에 맞는 풀이겠죠?
