# [1940] 주몽

## 분류
> 정렬
>
> 두 포인터

## 코드
```java
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

//        int cnt = 0;
//
//        for(int i = 0; i < arr.length - 1; i++){
//            for(int j = i + 1; j < arr.length; j++){
//                if(arr[i] + arr[j] == M){
//                    cnt++;
//                }
//            }
//        }
//
//        bw.write(cnt + " \n");
        Arrays.sort(arr);

        int cnt = 0, idx1 = 0, idx2 = N -1;

        while(idx1 < idx2){
            if(arr[idx1] + arr[idx2] < M) idx1++;
            else if(arr[idx1] + arr[idx2] > M) idx2--;
            else {
                cnt++;
                idx2--;
                idx1++;
            }
        }

        bw.write(cnt + " \n");
        bw.flush();
        bw.close();
    }
}
```

## 문제풀이

포인터를 앞에서부터 같이 증가시키는 방법과 앞 뒤에서 각각 증가/감소시키는 방법 두가지가 있다.

바로 떠오르는 풀이는 이중 for문을 사용하는 것이라, 그렇게 풀었다. 타임아웃 걱정을 하긴 했는데 그정도는 아닌듯.. 실버 4라 그런강 🧐 - 396ms

두번째는 맨 앞과 맨 뒤에 포인터를 두고 조건에 맞게 앞에서 증가시키거나 뒤에서 감소시키는 방법이다. 이는 배열이 오름차순으로 정렬되어 있어야 성립한다. 뭐.. 내림차순이어도 비슷하겠다. - 240ms

반복문이 하나 줄어서인지 시간이 훨씬 짧아짐을 알 수 있따.


