# [Leetcode 844] Backspace String Compare

## 분류
> Two Pointers
> 
> String
> 
> Stack
> 
> Simulation

## 코드
```java
class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder newS = new StringBuilder();
        StringBuilder newT = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char text = s.charAt(i);
            if(text == '#' && newS.length() > 0) newS.setLength(newS.length() - 1);
            else if(text == '#' && newS.length() == 0) continue;
            else if(text != '#') newS.append(text);
        }
        for(int i = 0; i < t.length(); i++){
            char text = t.charAt(i);
            if(text == '#' && newT.length() > 0) newT.setLength(newT.length() - 1);
            else if(text == '#' && newT.length() == 0) continue;
            else if(text != '#') newT.append(text);
        }

        if(newS.toString().equals(newT.toString())) return true;
        else return false;
    }
}
```

## 문제풀이

스택으로 풀까 하다가, 굳이 자료구조를 쓰지 않아도 문자열로 충분히 풀 수 있을 것 같아 문자열로만 풀었다.

마지막 문자를 쉽게 지우기 위해서 StringBuilder를 사용했는데, 마지막에 비교할 때 equals는 StringBuilder에서 사용해도 == 과 동일한 값이 나온다. 원래 equals는 참조하고 있는 주소 값을 비교하기 때문에 == 연산자와 동일한 반환 결과가 나오게 되는 것인데, String 클래스는 값을 비교하도록 equals() 메서드가 재정의되어 주소값이 아닌 값 자체를 비교하게 되는 것이다. 하지만 StringBuilder는 equals() 메서드가 재정의되지 않았기 때문에 참조하고 있는 주소 값을 그대로 비교하게 되고, 때문에 비교 값은 불일치로 나오게 된다. 
이를 해결하기 위해서는 StringBuilder 객체를 toString() 메서드를 사용해 문자열로 변환한 후 equals() 메서드를 사용하면 된다.

Topic에 Two Pointers가 있는데, 어떻게 접근하는지 스터디에서 물어봐야징..
