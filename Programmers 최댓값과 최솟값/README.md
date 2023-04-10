# [Programmers 최댓값과 최솟값]

## 분류
> 

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pro최댓값과_최솟값 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        solution(str);

    }
    private static String solution(String s){
        String answer = "";
        StringTokenizer st = new StringTokenizer(s, " ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while(st.hasMoreElements()){
            int num = Integer.parseInt(st.nextToken());
            if(num > max){
                max = num;
            }
            if(num < min){
                min = num;
            }
        }
        answer = min + " " + max;
        return answer;
    }

}


```

## 문제풀이

프로그래머스로 처음 풀이해봤는데, 생각보다 까다롭다 ... 
문제에 대한 풀이는 따로 없음 !
배열에 담아서 min, max바로 구해줘도 됐는데, IDE를 안쓰니까 낯설어서 그냥 냅다 저렇게 해버림..
