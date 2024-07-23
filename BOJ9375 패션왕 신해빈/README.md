# [9375] 패션왕 신해빈

## 분류
> 수학
> 
> 자료 구조
> 
> 조합론
> 
> 해시를 사용한 집합과 맵

## 코드
```java
import java.io.*;
import java.util.*;

public class BOJ9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> clothesSet = new HashMap<>();

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String key = st.nextToken();

                if(clothesSet.containsKey(key)){
                    clothesSet.put(key, clothesSet.get(key) + 1);
                }else {
                    clothesSet.put(key, 1);
                }
            }

            int res = 1;

            for(int val : clothesSet.values()){
                res *= (val + 1);
            }

            bw.write(res - 1 + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
```

## 문제풀이

처음엔 `HashMap<String, List<String>>`으로 했는데, 전-혀 이럴 필요가 없다. 어차피 같은 의상이 있을 경우가 없다고 했기 때문에, `List<String>`의 size만 가져오면 된다. 즉, 리스트 대신 Integer로 입력받아도 전혀 상관이 없다는 것이다.  

그리고 나서 생각할 것은 해당 의상을 '입지 않는 경우'다.  
hat headgear  
sunglasses eyewear  
turban headgear  

이렇게 입력이 들어오면, headgear 2개, sunglasses 1개가 입력되는데 각각 착용하지 않는 경우도 생각해줘야한다. 그래서 headgear 3개, sunglasses 2개로 늘려두고 3 x 2를 해주면 모든 조합이 나올 수 있다. 즉, headgear : hat, turban, X 이렇게 되어 있는 것. 마지막으로 '알몸이 아닌 상태'를 유지해야 하기 때문에 모두 입지 않는 경우 하나만 빼주면 된다.
