# [Leetcode 226] Invert Binary Tree

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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        // TreeNode tree = root.left;
        // root.left = root.right;
        // root.right = tree;

        // invertTree(root.left);
        // invertTree(root.right);

        // return root;
        
        return new TreeNode(root.val, invertTree(root.right), invertTree(root.left));
    }
}
```

## 문제풀이

양쪽 트리 위치를 대칭시키는 문제다.

이제 Definition에 깊이 빠지지 않기로 했다.. 이게 뭐지 이게 뭐지 하면 더 늪으로 빠지는 듯해서.😭
그렇지만 이번엔 Definition을 너무 어렵게 보지 않아서인지 매개변수를 3개 가지는 생성자를 사용할 수 있었다. 단순히 왼쪽 자리에 오른쪽 트리를, 오른쪽 자리에 왼쪽 트리를 넣어주었다. 그럼 아래로 가면서 계속해서 알아서 뒤집어줌!
처음엔 스위칭해주는 방법으로 했는데, 갑자기 Definition이 눈에 들어옴.. 

아무튼 트리 문제 계속 풀어서 그런지 재미있어지려고 ..한다! 

백준의 DFS, BFS랑은 문제 유형이 너무 달라서 DFS라 생각 안하고 그냥 recursive만 생각하고 풀었는데, 큐에 넣었다 뺐다 하면 BFS로도 풀 수 있을 것 같다.
