# [Leetcode 283] Move Zeroes

## 분류
> Tree
> 
> Depth-First Search
> 
> Breadth-First Search
> 
> Binary Tree

## 코드
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        if(root == null) return false;

        return check(root.left, root.right);
    }

    public boolean check(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        else if(left == null || right == null) return false;

        if(left.val != right.val) return false;
        else return check(left.left, right.right) && check(left.right, right.left);
    }
}
```

## 문제풀이

주어진 트리가 대칭인가에 대해 참 거짓을 리턴하는 문제다.

트리노드 접근은 Definition을 참고하면 되고, 나는 '재귀'방법을 선택했다. 지금 풀이를 작성하면서 알게된 것이지만 Topic에 DFS, BFS가 있는 것으로 봐서는, 그래프 탐색으로 문제를 풀이해도 좋을 것 같긴 하다.

재귀 함수를 작성할 때, 필요한 노드는 다음 루트가 될 수 있는 정점들이기 때문에 left와 right 값들을 넘겨줬다. 
만약 둘 다 null값이라면 대칭일뿐만 아니라 탐색도 종료되어야하기에 true를 리턴, 둘 중 하나만 null값이라면 대칭이 깨어지기 때문에 false를 리턴하면서 탐색도 종료했다.
그 다음 조건은 두 값이 같은가를 비교한다. 두 값이 같지 않다면 false를 리턴하면서 탐색 종료, 두 값이 같다면 해당 값들을 root로, 왼쪽 자식과 오른쪽 자식이 같은가를 다시 반복해주면 된다.


bfs로 풀어보려 했는데.. 어차피 큐에 넣고 빼고만 추가될 뿐이지 조건문은 check함수 내에 작성한 것과 같이 작성하면 되는 것 같아서.... 생략-✨

