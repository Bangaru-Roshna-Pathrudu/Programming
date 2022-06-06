/*
There are N tourist places in India, where some are connected with each other 
through Airways and some or not. You will be given the Airways as routes[] array, 
where routes[i]=[X,Y], there is an direct airway route between place-X to place-Y 
and vice versa.

Reachability Score of two tourist places is defined as the total number of direct 
airway routes to any tourist place. If there is a common airway route between both
the tourist places, it is counted only once.

Your task is to find and return the maximum reachability score between any pair 
of tourist places among the N tourist places in INDIA.

Input Format:
-------------
Line-1:Two space separated integers, N number of places, and R number of routes.
Next R lines: Two space separated integers, X and Y. 

Output Format:
--------------
Print an integer, maximum reachability score.


Sample Input-1:
---------------
5 6
0 1
1 2
0 4
1 4
2 4
3 4

Sample Output-1:
----------------
6

Explanation:
------------
The Reachability Score of the tourist places place-1 is 3 and place-4 is 4 .
There is a common route between place-1 and place-4,
So, the maximum reachability score is 3+4-1 = 6.


Sample Input-2:
---------------
8 9
0 1
1 2
0 3
1 3
2 3
4 5
6 5
5 7
4 7

Sample Output-2:
----------------
6

*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int r = s.nextInt();
        int[][] routes = new int[r][2];
        for(int i=0;i<r;i++){
            routes[i][0] = s.nextInt();
            routes[i][1] = s.nextInt();
        }
        System.out.println(getMaximumReachabilityScore(routes,n));
    }
    
    static int getMaximumReachabilityScore(int[][] routes,int n){
        int[][] adjmat = new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(adjmat[i],0);
        int[] deg = new int[n];
        Arrays.fill(deg,0);
        for(int i=0;i<routes.length;i++){
            adjmat[routes[i][0]][routes[i][1]]=1;
            deg[routes[i][0]]++;
            adjmat[routes[i][1]][routes[i][0]]=1;
            deg[routes[i][1]]++;
        }
        int max = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i != j){
                    int sum = deg[i]+deg[j]-((adjmat[i][j] == 1)?(1):(0));
                    max = Math.max(sum,max);
                }
            }
        }
        return max;
    }
}
