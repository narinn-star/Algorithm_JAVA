# [Programmers 방문 길이]

## 분류
> Summer/Winter Coding(~2018)

## 코드
```java
import java.util.*;

class Solution {
    public int solution(String dirs) {
        int x = 0, y = 0;
        
        Set<String> path = new HashSet<>();
            
        for(int i = 0; i < dirs.length(); i++){
            char direction = dirs.charAt(i);
            int newX = x, newY = y;
            
            switch(direction){
                case 'U': 
                    newY++;
                    break;
                case 'D': 
                    newY--;
                    break;
                case 'R': 
                    newX++;
                    break;
                case 'L': 
                    newX--; 
                    break;
            }
            
            if(checkRange(newX, newY)){
                String originPath = x + " " + y + " " + newX + " " + newY;
                String reversePath = newX + " " + newY + " " + x + " " + y;
                path.add(originPath);
                path.add(reversePath);
                
                x = newX;
                y = newY;
            }
        }
        
        return path.size() / 2;
    }
    
    private static boolean checkRange(int x, int y){
        if(x > 5 || x < -5 || y > 5 || y < -5) return false;
        
        return true;
    }
}
```

## 문제풀이

이게 뭐라고 풀이가 1시간 20분이나 걸렸다.. 
List에 담겨 있는 배열이랑 담을 배열이랑 비교해서 겹치는 게 없으면 넣어주는 방식으로 하려했는데, 함수도 길어지고 switch case문도 점점 길어져서 어디서 오류가 발생했는지는 모르겠지만.. 진짜 1시간 15분만에 HashSet을 떠올리고 다 갈아엎었다.. 😭😭😭

(0, 0) -> (0, 1)을 넣었다면 (0, 1) -> (0, 0)도 넣어줘야 하는 것이 이 문제의 포인트고, 그렇기 때문에 리턴할 때 path.size()에 /2를 해줘야한다. 모든 경로가 두개씩 담겨있기 때문!

오래 푼 것 치고는 풀이를 쓸만한 게 없긴 하다.. 허탈함
