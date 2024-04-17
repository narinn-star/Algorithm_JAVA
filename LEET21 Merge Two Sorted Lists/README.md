# [Leetcode 21] Merge Two Sorted Lists

## 분류
> Linked List
> 
> Recursion

## 코드
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // if(list1 != null)
        //     System.out.println(list1.next.val);
        // return list1;
        // if(list1 == null) return list2;
        // if(list2 == null) return list1;

        ListNode result = new ListNode();
        ListNode next = result;

        while(list1 != null && list2 != null){
            if(list1.val > list2.val){
                next.next = list2;
                list2 = list2.next;
            }else{
                next.next = list1;
                list1 = list1.next;
            }
            next = next.next;
        }
        
        if(list1 == null) next.next = list2;
        else next.next = list1;

        return result.next;
    }
}
```

## 문제풀이

이놈의 definition은 적응이 안돼..

list1, list2가 각각 head인 게 포인트다. 그 다음 값에 접근하기 위해서는 next를 이용해야하고, 값은 val로 비교하면된다. 즉, 처음에 list1.val은 1이 나올거고, list1.next.val은 2가 나올 것.. (예제1번)

어차피 둘 다 오름차순으로 정렬되어있기 때문에 계속 비교해주기만 하면 된다. 둘 다 null이 될 때까지. 
각각 비교해주면서 미리 만들어둔 다른 리스트(결과를 담을 리스트)의 헤드에 더 작은 값을 넣어준 다음, 그 작은 값의 다음 값을 가리켜두면 된다.

반복문을 모두 실행한 다음에는 list1이 null이라면 다음에 list2를 붙여주고, 아니라면 list1을 다 붙여주면 된다. 

리턴에 result.next를 해준 이유는 영문을 모르겠으나 result를 하면 첫값이 비어서 나온다. 헤드가 비어있기 때문! 그래서 헤드를 뛰어넘고 그 다음값부터 출력하면 된다.

