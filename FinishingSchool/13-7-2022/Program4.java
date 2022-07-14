/*
Mr David Blaine is a famous magician, He has given a row of boxes[],where ith-box 
has box[i] amount of gold. He has also given an integer P.

Mr David Blaine, will separate the boxes into continuous row groups, where 
each group can contain atmost P number of boxes. After grouping is done, he
will perform the magic, then the amount of gold in each box of the group 
maximized to their group's highest amount of gold (i.e., if the group is [2,6,3],
after magic, the group is updated to [6,6,6] ).

Your task is to return the maximum amount of gold in the given row of boxes
after magic is performed by Mr David Blaine.


Input Format:
-------------
Line-1: Two space separated integers N and P, N number of boxes and P
Line-2: N comma separated integers, amount of gold in each box.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
7 3
3,5,12,8,9,3,14

Sample Output-1:
----------------
86

Explanation: 
------------
The boxes after grouping are [12,12,12,8,14,14,14]


Sample Input-2:
---------------
14 4
2,3,7,1,5,3,8,10,5,2,1,1,3,7

Sample Output-2:
----------------
114

Explanation: 
------------
The boxes after grouping are [7,7,7,7,8,8,8,8,10,10,10,10,7,7]


*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        s.nextLine();
        int[] ba = new int[n];
        String dum[] = s.nextLine().split(",");
        for(int i=0;i<n;i++) ba[i] = Integer.parseInt(dum[i]);
        System.out.println(getMaxSum(ba,n,k));
    }
    
    static int getMaxSum(int[] ba,int n,int k){
        int[] memo = new int[n];
        Arrays.fill(memo,-1);
        return helper(ba,n,k,0,memo);
    }
    
    static int helper(int[] ba,int n,int k,int ind,int[] memo){
        if(ind >= n) return 0;
        if(memo[ind] != -1) return memo[ind];
        int res=0,c=0,cur=0;
        for(int i=ind;i<n && c<k;i++){
            c++;
            cur = Math.max(cur,ba[i]);
            res = Math.max(res,(cur*c)+helper(ba,n,k,i+1,memo));
        }
        memo[ind] = res;
        return memo[ind];
    }
}
