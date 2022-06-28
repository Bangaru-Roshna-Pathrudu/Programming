/*
You are given some tokens printed with unique numbers on it and an integer T.
Your task is to find the least number of tokens that you need to make up the 
value T, by adding the numbers printed on all the tokens. 
If you cannot make the value T, by any combination of the tokens, return -1.

NOTE: Assume that you have unlimited set of tokens of each number type.

Input Format:
-------------
Line-1: Space separated integers tokens[], number printed on tokens.
Line-2: An integer T.

Output Format:
--------------
Print an integer, minimum number of tokens to make the value T.


Sample Input-1:
---------------
1 2 5
11

Sample Output-1:
----------------
3

Explanation:
------------
5+5+1 = 11


Sample Input-2:
---------------
2 4
15

Sample Output-2:
----------------
-1

*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String[] dum = s.nextLine().split(" ");
        int t = s.nextInt();
        int[] tok = new int[dum.length];
        for(int i=0;i<tok.length;i++) tok[i] = Integer.parseInt(dum[i]);
        System.out.println(getMinimum(tok,t));
    }
    
    static int getMinimum(int[] tok,int t){
        /*
        ArrayDeque<Integer> q = new ArrayDeque<>();
        List<Integer> vis = new ArrayList<>();
        q.offerLast(t);
        vis.add(t);
        int tot = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int temp = q.pollFirst();
                if(temp == 0) return tot;
                if(temp < 0) continue;
                for(int j=0;j<tok.length;j++){
                    int rem = temp - tok[j];
                    if(rem>=0 && !vis.contains(rem)){
                        q.offerLast(rem);
                        vis.add(rem);
                    }
                }
            }
            tot++;
        }
        return -1;
        */
        int dp[] = new int[t+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1;i<=t;i++){
            for(int j=0;j<tok.length;j++){
                if(i-tok[j]>=0 && dp[i-tok[j]] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],dp[i-tok[j]]+1);
                }
            }
        }
        return (dp[t]==Integer.MAX_VALUE)?(-1):(dp[t]);
    }
}
