# [Leetcode 383] Ransom Note

## 분류
> Hash Table
> 
> String
> 
> Counting

## 코드
```java
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < magazine.length(); i++){
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 1) + 1);
        }

        for(int i = 0; i < ransomNote.length(); i++){
            char c = ransomNote.charAt(i);
            if(map.containsKey(c) && map.get(c) - 1 > 0)
                map.replace(c, map.get(c) - 1);
            else return false;
        }

        return true;
    }
}
```

```java
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magazineChar = new int[26];

        for(int i = 0; i < magazine.length(); i++){
            magazineChar[magazine.charAt(i) - 'a']++;
        }

        for(int i = 0; i < ransomNote.length(); i++){
            char c = ransomNote.charAt(i);
            if(magazineChar[c - 'a'] > 0)
                magazineChar[c - 'a']--;
            else return false;
        }

        return true;
    }
}
```

## 문제풀이

두가지 방법으로 풀어봤다. 원래 바로 배열에 담는 걸 생각했는데, HashMap을 잘 활용해보지 않아서 익숙해지려고 일부러 HashMap을 사용해봤다. 당연히 문자열로 처리해버리는게 훨씬 빠르다!

내부 로직은 완전 똑같다. magazine 알파벳을 배열에 담을 것인지, 맵에 담을 것인지만 다르고 똑같다. 문자열로 사용할 땐 'a'를 빼서 숫자로 적절히 바꿔주기만 하면 인덱스 찾아가기는 어렵지 않다.

getOrDefault(Key, defaultValue)함수는 key값이 있다면 value를, 없다면 defaultValue를 가져온다. 즉, a가 두번째 들어가는 값이면 1이 반환되기 때문에 +1을 해주면 a에는 2가 들어가게 되는 것. 만약 a가 첫번째라면 defaultValue를 1로 설정해줬기 때문에 a, 1이 들어가게 된다.
hashMap에 여러가지 메소드가 정말 많은데, 많이 사용해봐야겠씀..!!!
