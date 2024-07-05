# [10819] 차이를 최대로

## 분류
> 브루트포스 알고리즘
> 
> 백트래킹

## 코드
```java
import java.io.*;
import java.util.StringTokenizer;

public class BOJ10819 {
    static int N, max;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        max = 0;
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(0);

        bw.write(max + "\n");
        bw.flush();
        bw.close();

    }
    static void backtrack(int a){

        if(a == arr.length - 1){
            int sum = 0;
            for(int i = 0; i < arr.length - 1; i++){
                sum += Math.abs(arr[i] - arr[i + 1]);
            }

            if(sum > max) {
                max = sum;
            }
        } else {
            for(int i = a; i < arr.length; i++){
                swap(a, i);
                backtrack(a + 1);
                swap(a, i);
            }
        }
    }

    static void swap(int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
```

## 문제풀이

풀고 나니 N과 M이랑 다를 게 없는 문제였는데, 엄청 꼬아서 풀었다. 배열 하나로 처리하려고 하다 보니, 배열 순서를 바꿨다가 다시 풀어주는 방식으로 했는데 이게 왜 돼? 임.. ㅋㅋ

어쨌든 하나씩 무조건 다 돌면서 가장 큰 값을 찾아줘야 하는 거였다. 생각만해도 시간이 어마어마하게 걸릴 것 같다는 생각을 했는데, 데이터 값도 작아서 이게 맞구나 싶었음..

백트래킹 어려워욥
