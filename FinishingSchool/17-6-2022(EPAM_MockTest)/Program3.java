/*
Mr Shravan is playing a Match-the-Pair Game.
Initially, He is given two teams team1 and team2.
Each team has some persons in it, each person is identified with an ID,
ID's are positive numbers, duplicates are allowed.

Your task is to match the persons from team1 to team2.
Team1 consist of M persons and Team2 consist of N persons.
And the rules for matching the persons are as follows:
	- You are allowed to match the persons from team1 with team2,
	only if the IDs are equal and you have to draw a line between the pair.
	- You are not allowed draw the line which is passing through another line.
	- If you are not allowed to draw the line, you cannot match the pair.
	- Each person must connected with atmost one person only.

Finally, count the maximum numbers of pairs can be formed between the teams.


Input Format:
-------------
Line-1: Two space separated integers, M and N.
Line-2: M space separated integers, team1[].
Line-3: N space separated integers, team2[]. 

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
4 4
1 2 3 5
3 1 5 2

Sample Output-1:
----------------
2

Explanation: 
------------
You can Match the pair as follows: 
S1 - team1[0]-team2[1], team1[1]-team2[3]
S2 - team1[0]-team2[1], team1[3]-team2[2]
S3 - team1[2]-team2[0], team1[3]-team2[2]
In S1 you cannot match 3 with 3 or 5 with 5, because you are
not allowed to draw a line. same for S2 and S3.


Sample Input-2:
---------------
6 7
6 5 2 4 2 5
2 5 3 4 6 2 4

Sample Output-2:
----------------
3

*/

import java.util.*;

class Solution{
    
    static int memo[][];
    
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        int[] t1 = new int[m];
        int[] t2 = new int[n];
        memo = new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(memo[i],-1);
        for(int i=0;i<m;i++) t1[i] = s.nextInt();
        for(int i=0;i<n;i++) t2[i] = s.nextInt();;
        System.out.println(maxPairsMade(t1,t2));
    }
    
    static int maxPairsMade(int[] t1,int[] t2){
        return helper(t1,t2,t1.length-1,t2.length-1);
    }
    
    static int helper(int[] t1,int[] t2,int ind1,int ind2){
        if(ind1 < 0 || ind2 < 0){
            return 0;
        }
        if(memo[ind1][ind2] != -1) return memo[ind1][ind2];
        if(t1[ind1] == t2[ind2]) return memo[ind1][ind2] = 1 + helper(t1,t2,ind1-1,ind2-1);
        return Math.max(helper(t1,t2,ind1,ind2-1),helper(t1,t2,ind1-1,ind2));
    }
}
/*
import java.util.*;

class Solution{
    
    static Map<String,Integer> memo = new HashMap<>();
    
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        int[] t1 = new int[m];
        int[] t2 = new int[n];
        for(int i=0;i<m;i++) t1[i] = s.nextInt();
        for(int i=0;i<n;i++) t2[i] = s.nextInt();;
        System.out.println(maxPairsMade(t1,t2));
    }
    
    static int maxPairsMade(int[] t1,int[] t2){
        return helper(t1,t2,t1.length-1,t2.length-1);
    }
    
    static int helper(int[] t1,int[] t2,int ind1,int ind2){
        if(ind1 < 0 || ind2 < 0){
            return 0;
        }
        String key = ind1+"-"+ind2;
        if(memo.containsKey(key)) return memo.get(key);
        if(t1[ind1] == t2[ind2]){
            memo.put(key,1+helper(t1,t2,ind1-1,ind2-1));
            return memo.get(key);
        }
        memo.put(key,Math.max(helper(t1,t2,ind1,ind2-1),helper(t1,t2,ind1-1,ind2)));
        return memo.get(key);
    }
}
*/
