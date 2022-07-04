/*
Mr Ashoka planted N trees in a land around the Flag Post which is at the center 
of the land, i.e., (0,0) position. You will be given the positions of N trees
as trees[], where tree[i]=[Xi,Yi], where Xi, Yi are the positions of i-th tree
with respect to X-axis and Y-axis. And you are also an integer C.

The distance between any two trees on the land plane is the Euclidean distance 
(i.e., sqrt((x1 - x2)^2 + (y1 - y2)^2).

Your task is to return positions of the C trees Nearest to the Flag post. 
The answer is supposed to be sorted based on distance, if the distances 
are same keep the original order of the trees[].


Input Format:
-------------
Line-1: Two space separate integers, N and C
Next N Lines: Two space separated integers, x,y

Output Format:
--------------
Print the positionf of C Nearest Trees.

Sample Input-1:
---------------
4 4
-3 -3
3 -3
3 3
-3 3

Sample Output-1:
----------------
[-3, -3] [3, -3] [3, 3] [-3, 3]


Sample Input-2:
---------------
4 3
2 -1
1 2
2 4
3 2

Sample Output-2:
----------------
[2, -1] [1, 2] [3, 2]

*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int c = s.nextInt();
        List<List<Integer>> pos = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> coor = new ArrayList<>();
            coor.add(i);
            coor.add(s.nextInt());
            coor.add(s.nextInt());
            pos.add(coor);
        }
        System.out.println(getCNearestTrees(pos,n,c));
    }
    
    static List<List<Integer>> getCNearestTrees(List<List<Integer>> pos,int n,int c){
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new Comparator<List<Integer>>(){
            public int compare(List<Integer> p,List<Integer> q){
                int dist1 = (int)(Math.pow(p.get(1),2) + Math.pow(p.get(2),2));
                int dist2 = (int)(Math.pow(q.get(1),2) + Math.pow(q.get(2),2));
                if(dist1 == dist2) return p.get(0)-q.get(0);
                else return dist1-dist2;
            }
        });
        for(int i=0;i<n;i++){
            pq.offer(pos.get(i));
        }
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        while(!pq.isEmpty() && i++<c){
            List<Integer> coor = pq.poll();
            coor.remove(0);
            result.add(coor);
        }
        return result;
    }
}
