# [2920] 음계

## 분류
> 구현

## 코드
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2920 {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      String asc = "1 2 3 4 5 6 7 8";
      String dsc = "8 7 6 5 4 3 2 1";
      
      String input = br.readLine();
      if(input.equals(asc)) {
         bw.write("ascending");
      }
      else if(input.equals(dsc)) {
         bw.write("descending");
      }
      else {
         bw.write("mixed");
      }
      
      bw.flush();
      bw.close();
      br.close();
   }
}
```

## 문제풀이

그냥 문자열로 간단하게 풀 수 있는 문제. ascending과 descending을 문자열에 따로 저장해두고 입력받은 문자열과 비교하면 된다. 

출력문 조심.. descending을 decending으로 출력해서 한참 틀리다가 고쳤다... 

굳이 배열로 풀지 않아도 쉽게 풀 수 있는 문제인 것 같다. 다들 배열로 풀긴 하지만..?