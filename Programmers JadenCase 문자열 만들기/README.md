# [Programmers JadenCase 문자열 만들기] 

## 분류
> 연습문제

## 코드
```java
class Solution {
    public String solution(String s) {
        String answer = "";
        
        if(s.charAt(0) < 0 && s.charAt(0) > 9) answer += s.charAt(0);
        else answer += Character.toString(s.charAt(0)).toUpperCase();
        
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i - 1) == ' '){
                answer += Character.toString(s.charAt(i)).toUpperCase();
            }else {
                answer += Character.toString(s.charAt(i)).toLowerCase();
            }
        }
        
        return answer;
    }
}
```

## 문제풀이

JadenCase 문자열을 만드는 문제다. (사실 JadenCase 처음 알았음..)

JadenCase는 문제에서 말하듯, 모든 단어의 첫 문자가 대문자이고 나머지 알파벳은 소문자인 문자열이다. 예제에서처럼 숫자가 맨 앞에 오는 경우에는 숫자가 첫 문자이기 때문에 그 다음 문자가 알파벳이라고 해도 대문자로 바뀌진 않는다.

즉, 맨 앞글자만 대문자로 바꿔주면 되는 것이다. 나는 ' ' 공백을 사용해서 맨 앞글자를 인식하도록 하기 위해 맨 앞글자는 반복문에서 빼서 체크해줬다. 만약 숫자라면 그냥 넣고, 그렇지 않으면 대문자로 바꾸기만 하면 된다. 
그럼 반복문은 0번이 아닌 1번부터 시작하고 [i - 1]이 공백이라면 i는 무조건 대문자로 바꿔준 후에 answer 문자열에 붙여주고 그렇지 않으면 (대문자일수도 있기 때문에) 소문자로 바꾸어 answer에 붙여주면 된다.

지금 풀이를 적으면서 깨달은 것인데,, 그냥 s.charAt(i)가 숫자일 때 예외처리를 하지 않아도 되는건가..? 다른 테스트 케이스를 추가해서 확인해도 정상작동 하는 것 보니 UpperCase 처리를 해도 그대로인 듯하다.
