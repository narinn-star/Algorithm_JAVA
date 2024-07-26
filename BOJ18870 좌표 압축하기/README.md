# [18870] 좌표 압축

## 분류
> 정렬
>
> 갑 / 좌표 압축

## 코드
```java
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sortedArr;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sortedArr = arr.clone();

        Arrays.sort(sortedArr);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for(int i = 0; i < N; i++){
            if(!map.containsKey(sortedArr[i])){
                map.put(sortedArr[i], rank);
                rank++;
            }
        }

        for(int i = 0; i < N; i++){
            bw.write(map.get(arr[i]) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

```

## 문제풀이

문제만 보면 무슨 소리인가 싶은데, 예제를 수직선에 그려보면 rank를 나타내는 걸 알 수 있다.  
정렬하면 끝 아닌가? 했지만 기존 배열의 순서에 맞게 순위를 출력해야하기 때문에, 배열이 하나 더 필요하다.  
하나는 기존 배열, 하나는 정렬한 배열로 두고, 정렬된 배열으로 순위를 매기면 된다. 순위를 매길 때는 map을 사용했다. (value, rank)으로 저장하고나서 다시 for 루프를 돌면서 기존 배열의 값을 key로 가지는 rank를 출력하면 된다.

