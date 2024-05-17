# [Leetcode 13] Roman to Integer

## 분류
> Hash Table
> 
> Math
> 
> String

## 코드
```java
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romanInt = new HashMap<>();

        romanInt.put('I', 1);
        romanInt.put('V', 5);
        romanInt.put('X', 10);
        romanInt.put('L', 50);
        romanInt.put('C', 100);
        romanInt.put('D', 500);
        romanInt.put('M', 1000);

        int result = 0;

        for(int i = 0; i < s.length(); i++){
            char roman = s.charAt(i);
            if(i < s.length() - 1 && romanInt.get(roman) < romanInt.get(s.charAt(i + 1))) {
                result -= romanInt.get(roman);
            } else {
                result += romanInt.get(roman);
            }
        }
        return result;
    }
}
```

## 문제풀이

조건문으로 하나씩 다 따져주려다, HashMap을 한 번 사용해보고 싶어서 HashMap에 저장하고 풀어봤다.
문제에서 주어진 Symbol과 Value를 hashmap에 넣어주고 하나씩 꺼내서 뻴셈을 해줘야할 때와 덧셉을 해줘야할 때를 나누어 계산했다.

간단한 문자열 문제라 어렵지 않게 풀었다.
