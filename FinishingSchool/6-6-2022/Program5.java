/*
VishnuVardan is working with Binary Trees.
He wants to find all the sub trees with following conditions:
    - A single node is also considered as a tree with no childs. 
    - If the root node value of th tree is X, then all the node values 
    in that tree should be X.

Your task is to help VishnuVardan to find the number of sub trees are there 
in the given tree with the given terms.

Your task is to implement the class Solution:
	- public int countSubtrees(BinaryTreeNode root)
	return an integer result.

NOTE: Please do consider node with value -1 as null node.


Input Format:
-------------
Space separated integers, nodes of the tree.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
2,1,2,1,1,2,2

Sample Output-1:
----------------
6


Sample Input-2:
---------------
1,2,3,4,5,6,7

Sample Output-2:
----------------
4
*/

import java.util.*;

/*

class BinaryTreeNode{
	public int data; 
	public BinaryTreeNode left, right; 
	public BinaryTreeNode(int data){
		this.data = data; 
		left = null; 
		right = null; 
	}
}

*/

class Solution {
    public int countSubtrees(BinaryTreeNode root) {
        //implement your code here
        return helper(root);
    }
    
    static int helper(BinaryTreeNode root){
        if(root == null || root.data == -1) return 0;
        if((root.left == null || root.left.data == -1) && (root.right == null || root.right.data == -1)) return 1;
        int num = helper(root.left) + helper(root.right);
        if(root.data == root.left.data || root.data == root.right.data) num++;
        return num;
    }
}
