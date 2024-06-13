# [15565] 귀여운 라이언

## 분류
> 두 포인터
>
> 슬라이딩 윈도우

## 코드
```java
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        // 슬라이딩 윈도우
        ArrayList<Integer> lion = new ArrayList<Integer>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] == 1) lion.add(i);
        }

        if(lion.size() < K) {
            bw.write("-1" + "\n");
            bw.flush();
            bw.close();
            return;
        }

        int start = 0, end = K - 1, cnt = 0;
        int min = Integer.MAX_VALUE;

        while(end != lion.size()){
            cnt = lion.get(end) - lion.get(start) + 1;
            min = Math.min(min, cnt);

            start++;
            end++;
        }

        bw.write(min + "\n");
        bw.flush();
        bw.close();

// 투 포인터
//        st = new StringTokenizer(br.readLine());
//        for(int i = 0; i < N; i++){
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//        int start = 0;
//        int end = 0;
//        int cnt = 0;
//        int min = Integer.MAX_VALUE;
//
//        while(start < N){
//            while(end < N && cnt < K){
//                if(arr[end] == 1) cnt++;
//
//                end++;
//            }
//
//            if(cnt == K){
//                min = Math.min(min, end - start);
//            }
//
//            if(arr[start] == 1) cnt--;
//            start++;
//        }
//
//        if(min == Integer.MAX_VALUE) {
//            bw.write("-1" + "\n");
//        }else {
//            bw.write(min + "\n");
//        }
//
//        bw.flush();
//        bw.close();
    }
}
```

## 문제풀이

투 포인터, 슬라이딩 윈도우 모두 구현 가능한 문제였다.
1. 투 포인터

[겹치는 건 싫어](https://github.com/narinn-star/Algorithm_JAVA/tree/master/BOJ20922%20%EA%B2%B9%EC%B9%98%EB%8A%94%20%EA%B1%B4%20%EC%8B%AB%EC%96%B4) 이 문제와 거의 비슷하게 풀었다. end값을 `cnt < K`일 때까지 돌면서 end값을 증가시키는데 arr[end]값이 1일 때 cnt값을 증가시켰다. 만약 cnt가 K와 같아지면 자동으로 while문을 탈출하게 되고, 그 때 min값을 계산해주면 된다. 그리고 start값을 하나 옮겨줘야하는데, 옮기기 전에 arr[start]값이 1이었다면 cnt를 빼주어야하고, 그렇지 않으면 그냥 start만 증가시키면 된다. 처음에 while문 탈출 값을 `end < N`으로 해두어서, 끝까지 돌지 않아 계속 헤맸다..

2. 슬라이딩 윈도우

1 (라이언)이 나올 때마다 해당 인덱스를 리스트에 추가해두고, K만큼 범위를 잘라 end - start + 1 로 min값을 구하는 것이다.

토픽에 슬라이딩 윈도우가 있어서 어떻게 푸는 건가~ 하며 다른 블로그를 참고해봤다. 진짜 많이 연습해봐야겠다 생각하게 된 풀이법이었다..😰


