/*
There are N Trees planted on flat land at various positions along X-Axis.
You are given the X-Axis poistions of the trees in ascending order.
Mr Bilahari wants to setup a water irrigation system for T trees which are 
near to point-X.

Your task is to find and return the positions of the T nearest trees to point-X.
and answer should be ascending order. To find the nearest positions of trees to 
point-X, the rule is as follows:
	- if there are two trees at posistions X1 and X2 then
	- [ |X1 - X| < |X2 - X| ] OR [ (|X1 - X| == |X2 - X| ) and X1 < X2 ]
	

Input Format:
-------------
Line-1: 3 space separated integers N, T, X, number of trees, values of T and X.
Line-2: N space separated integers, posistions of the trees.

Output Format:
--------------
Print the list of the posistions of T trees near to point-X.


Sample Input-1:
---------------
6 3 7
1 4 5 7 9 10 

Sample Output-1:
----------------
[5, 7, 9]



Sample Input-2:
---------------
6 4 2
-3 -1 0 1 3 4 

Sample Output-2:
----------------
[0, 1, 3, 4]


*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int p = s.nextInt();
        int[] co = new int[n];
        for(int i=0;i<n;i++) co[i] = s.nextInt();
        System.out.println(getNearestPoints(co,m,p));
    }
    
    static List<Integer> getNearestPoints(int[] co,int m,int p){
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return a[1]-b[1];
            }
        });
        for(int i=0;i<co.length;i++){
            pq.offer(new int[]{co[i],Math.abs(co[i]-p)});
        }
        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty() && m-->0) result.add(pq.poll()[0]);
        Collections.sort(result);
        return result;
    }
}
