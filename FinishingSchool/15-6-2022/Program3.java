/*
In a forest, There are N redwoord trees in a row.
You are given the heights of the trees as heights[],

You are task is to find the longest tree arrangement as follows:
	- Minimum size of the tree arrangement is 3.
	- And there exist a Tree-'i' with heights[i], where 0 < i < N-1.
		- heights[0] < heights[1] < heights[2] <...< heights[i] and
		-  heights[i] > heights[i+1] > heights[i+2] >...>heights[N-1] 

And return the length of the longest tree arrangement.
If there is no such arrangement, return 0.

Input Format:
-------------
Line-1: An integer N, number of elements.
Line-2: N space separated integers, value of the elements.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
8
4 2 5 7 4 2 3 6

Sample Output-1:
----------------
5

Explanation:
------------
The longest tree arrangement is : 2 5 7 4 2


Sample Input-2:
---------------
4
2 4 5 7

Sample Output-2:
----------------
0

*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] trees = new int[n];
        for(int i=0;i<n;i++) trees[i] = s.nextInt();
        System.out.println(longestMountain(trees,n));
    }
    
    static int longestMountain(int[] trees,int n){
        int max = 0;
        for(int i=1;i<n-1;i++){
            if(trees[i]>trees[i-1] && trees[i]>trees[i+1]){
                int l=i-1,h=i+1;
                while(l>0 && trees[l]>trees[l-1]) l--;
                while(h<n-1 && trees[h]>trees[h+1]) h++;
                max = Math.max(max,h-l+1);
            }
        }
        return max;
    }
}
