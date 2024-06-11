# [3273] 두 수의 합

## 분류
> 정렬
>
> 두 포인터
>

## 코드
```java
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int left = 0, right = arr.length - 1, cnt = 0;

        while(left < right){
            if(arr[left] + arr[right] < x) {
                left++;
            }else if(arr[left] + arr[right] > x){
                right--;
            }else{
                cnt++;
                left++;
                right--;
            }
        }

        bw.write(cnt +"\n");
        bw.flush();
        bw.close();
    }
}

```

## 문제풀이

주몽 문제와 다를 게 없는 문제다. 
처음에 while 조건문을 `left <= right`로 제출해서 한 번 틀렸다. 예제에서는 우연히 left와 right값이 같을 때의 합이 정답에 영향을 주지 않아 통과됐지만, 아마 다른 테스트케이스에서 걸렸을 것.

나머지는 주몽 문제랑 너무 똑같아서, 설명은 생략-
