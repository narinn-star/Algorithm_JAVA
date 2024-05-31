# [Leetcode 75] Sort Colors

## 분류
> Array
> 
> Two Pointers
> 
> Sorting

## 코드
```java
class Solution {
    public void sortColors(int[] nums) {
        // two pointer (?)
        int current = 0, zeroIndex = 0, twoIndex = nums.length - 1;

        for(int i = 0; i < nums.length; i++){
            if(nums[current] == 0){
                swap(nums, current++, zeroIndex++);
            }else if(nums[current] == 2){
                swap(nums, current, twoIndex--);
            }else{
                current++;
            }
        }
        // 브루트포스
        // for(int i = 0; i < nums.length - 1; i++){
        //     for(int j = i + 1; j < nums.length; j++){
        //         if(nums[i] > nums[j]){
        //             int tmp = nums[i];
        //             nums[i] = nums[j];
        //             nums[j] = tmp;
        //         }
        //     }
        // }
    }
    private static void swap(int[] nums, int left, int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
```

## 문제풀이

정렬 문제인데, sort 메서드 사용하지 않고 직접 정렬을 구현해야하는 문제다. 항상 정렬이면 Arrays.sort()나 Collections.sort()를 사용해왔던 나에겐 이런 문제가 가장 난감하다.. 

우선 Arrays.sort()와 Collections.sort()가 직접 구현하는 것보다 느리기 때문에 이런 문제가 출제되었다고 생각해서 둘의 시간 복잡도와 둘의 차이점에 대해 먼저 찾아보았다.

Arrays.sort()는 DualPivotQuickSort로 평균 O(nlogn), 최악 O(n^2)이며 
Collections.sort()는 TimeSort(삽입 정렬 + 합병 정렬)로 평균, 최악 모두 O(nlogn)의 시간복잡도를 갖는다. 
어쨌든 평균 nlogn으로 같기 때문에 크게 제한이 없는 이상 무조건 Collections.sort()를 사용하지는 않아도 될 듯했..다 (아닌가)

![graph](https://www.google.com/url?sa=i&url=https%3A%2F%2Fvelog.io%2F%40jaeseok-go%2F%25EC%25A0%2595%25EB%25A0%25AC-%25EC%2595%258C%25EA%25B3%25A0%25EB%25A6%25AC%25EC%25A6%2598%25EC%259D%2598-%25EC%258B%259C%25EA%25B0%2584-%25EB%25B3%25B5%25EC%259E%25A1%25EB%258F%2584&psig=AOvVaw29_9O8wRavUcJvjIy3XHy7&ust=1717233770806000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCMiIjLnIt4YDFQAAAAAdAAAAABAY)
그럼 이보다 빠르게 정렬할 수 있는 방법이 있다는 것인데, 정렬의 종류를 살펴봐도 다 nlogn뿐이지 더 빠른걸 알 수 없었다.. 

다른 코드를 참고해보니, 0과 2일 때 swap을 해주는 방식을 사용하고 있었다. 그렇게 하면 2는 맨 뒤로 계속 보내주기 때문에 최대 n번만 수행하는 것을 알 수 있다. O(n)으로 겁내 빠른것😲

nums[current]가 0일 때는 앞으로 보내주고, 2일 때는 뒤로, 1일때는 그대로 있으면 0, 2일 때 알아서 정렬된다. 

찾아보니 네덜란드 국기 알고리즘이라고 하는데, 진짜 처음 들어봄.. 시간 복잡도는 O(n)으로 빠르고 공간 복잡도도 O(1)로 매우 작다.. 
새로운 정렬 방법을 알게 되어씀

