# [Leetcode 283] Move Zeroes

## 분류
> Array
> 
> Hash Table
> 
> Math
> 
> Binary Search
> 
> Bit Manipulation
> 
> Sorting

## 코드
```java
class Solution {
    public int missingNumber(int[] nums) {
        int number = 0;

        Arrays.sort(nums);

        int arr[] = new int[nums.length+1];

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) arr[0] = -1;
            else arr[nums[i]] = nums[i];
        }

        if(arr[0] == 0) number = 0;
        else {
            for(int i = 1; i < arr.length; i++){
                if(arr[i] == 0) number = i;
            }
        }
        
        return number;
    }
}
```

## 문제풀이

이게 뭐라고 오래 걸렸다.. 뭔가 더 간단하게 풀으려(?) 조건식을 우다닥 집어넣다가 실패했는데, 배열 하나를 만들어서 해당 인덱스에 값을 채워주고, 없는 값을 number에 넣어 리턴했다.

굳이 이렇게 안하고 boolean을 두고 true로 해두면 좀 더.. 쉬우려낭?

내가 푼 건 아래와 같이 생각해서 풀었다.

- Input: nums = [0, 1, 3]
- arr 배열을 nums.length + 1만큼 크기를 지정해 선언
- arr[nums[i]] = nums[i]를 하면 arr = [-1, 1, 0, 3] 처럼 나오고, 0이 들어간 인덱스를 출력

오.. 생각해보니 그냥 [true, true, false, true]를 해두고 false가 있는 인덱스를 출력하면 끝이구나 싶네용
+ Arrays.sort() 함수도 필요가 없어요... 시간만 잡아 먹는 다는 사실을 알았읍니다.
