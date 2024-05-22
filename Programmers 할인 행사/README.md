# [Programmers 할인 행사]

## 분류
> 연습문제

## 코드
```java
import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < want.length; i++){
            map.put(want[i], number[i]);
        }
        
        for(int i = 0; i < discount.length - 10 + 1; i++){
            Map<String, Integer> discountMap = new HashMap<>();
            
            boolean flag = true;
            
            for(int j = i; j < i + 10; j++){
                discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);  
            }
            
            for(String key : map.keySet()){
                if(map.get(key) != discountMap.get(key)){
                    flag = false;
                    break;
                }
            }
            
            if(flag) answer++;

        }
        
        return answer;
    }
}
```

## 문제풀이

소요 시간 : 1시간 미만

HashMap 사용이라는 것 까지 접근은 아주 좋았으나.. 로직이 아주 잘못됐다. HashMap을 자주 써보지 않아서 메소드를 하나씩 찾아보면서 풀었다.
처음엔 discountMap 없이 정현이가 원하는 제품,개수를 담은 맵만 이용해서 discount[j]와 같으면 갯수를 -- 해주는 방식으로 했다. 아주 바보같은 생각이었음.. -- 해주면 원래대로 돌릴 수가 없으니까 두번째 반복문을 돌면 당연히,,,, 남아있는 갯수가 없어서 원하는만큼 반복을 할 수가 없었던 것 😂

그래서 discountMap을 계속 새로 만들어주면서 하기로 했다. 그대신 10개씩만 만들었다. 어차피 10개씩만 비교하면 되니까, 굳이 크게 만들지 않아도 된다. 크게 만들면 대참사.. discount 최대 길이가 10만개이기 때문! 

무튼 10개씩 discountMap도 만들어주고, 두 맵이 일치하지 않으면 flag = false를 해주고 반복문이 끝났을 때 true인 경우만 answer++을 했다. 

이번 문제는 생각하는 건 그리 오래걸리지 않았지만 HashMap 메서드에 대해 아주 많이 알 수 있었다. 익숙해질 수 있도록 HashMap 문제도 많이 풀어봐야겠다
[참고 블로그](https://kadosholy.tistory.com/120)
