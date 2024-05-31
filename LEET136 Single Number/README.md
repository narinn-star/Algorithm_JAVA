# [Leetcode 136] Single Number

## 분류
> Array
> 
> Bit Manipulation

## 코드
```java
class Solution {
    public int singleNumber(int[] nums) {
        // 비트연산자 사용
        int n = nums[0];

        for(int i = 1; i < nums.length; i++){
            n = n^nums[i];
        }

        return n;

        // HashSet 사용
        HashSet<Integer> set = new HashSet<>();

        for(int n : nums) {
            if(set.contains(n)) set.remove(n);
            else set.add(n);
        }

        for(int s : set){
            return s;
        }
        return -1;
    }
}
```

## 문제풀이

Topic을 보고 비트 연산자로 푸는 문제라는 것을 알았지만, 비트 연산자는 써본 경험이 없어서 떠오르는 대로 Set을 사용해서 먼저 풀었다. 
HashSet은 key, value를 저장하는 HashMap과 달리 객체 자체를 저장하기 때문에 nums의 숫자들을 저장하고 제거하는 데 적합하다. set에 숫자가 없다면 넣어주고, 이미 있는 숫자라면 해당 숫자를 제거한다. 제거되었다는 것은 2번 들어있다는 것이고 남아 있다면 single number이라는 의미다. 

비트 연산자는 따로 공부를 해보고 풀어보았다.
비트 논리 연산자는 |, &, ^, ~ 네가지로, 각각 다음과 같이 동작한다.

| : 하나라도 1이라면 1
& : 둘 다 1일때만 1
^ : 하나는 0, 하나는 1일 때 1
~ : 0일 때 1, 1일 때 0

사실 여기까지 보고도 문제에 어떻게 적용해야할 지 몰라서 다른 코드들을 참고했다.
XOR 연산자인 ^가 사용되었는데, 단순히 서로 다를 때만 결과가 1이라는 것만 보고도 알 수 없었다..
n ^= nums[i]라는 것을 보고 예제를 하나씩 계산해보았다.

Example 1: nums = [2,2,1]
👉🏻 n = nums[0]  (n = 2, 0010)
    i = 1일 때
    n = n ^ nums[i] (0010 ^ 0010 == 0000, n = 0)
    i = 2일 때
    n = n ^ nums[i] (0000 ^ 0001 == 0001, n = 1)
    => 1

Example 2: nums = [4,1,2,1,2]
👉🏻 n = nums[0] (n = 4, 0100)
    i = 1일 때
    n = n ^ nums[i] (0100 ^ 0001 == 0101, n = 5)
    i = 2일 때
    n = n ^ nums[i] (0101 ^ 0010 == 0111, n = 7)
    i = 3일 때
    n = n ^ nums[i] (0111 ^ 0001 == 0110, n = 6)
    i = 4일 때
    n = n ^ nums[i] (0110 ^ 0010 == 0100, n = 4)
    => 4
    
소름..
당연히 같은 값을 XOR하면 0000이 나오기 때문에 두 번 계산된 값은모두 0000이 되어 한 번 들어간 값이 나오게 되는 것이다.

항상 겁내고 비트연산자를 피해왔는데 찰나지만 너무 재미있었다🫢
