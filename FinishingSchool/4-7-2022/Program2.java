/*
There are N cities in a state.
The cities are connected with two types of roadways:
1) concrete roadway 2) asphalt roadway.
The roadways may be parallel.

You are given the lists of concrete roadways and asphalt roadways
between the cities. All roadways are unidirectional.
Concrete_Roadway[i,j] indiactes: a concrete road from city-i to city-j. Similarly,
Asphalt[i,j] indiactes: an asphalt road from city-i to city-j. Similarly,

Your task is to find and return the list of lengths of the shortest paths from 
city-0 to city-P, where P start from 0 to N-1. And the path should contains 
alternative roadways like as follows: concrete - asphalt - concrete -asphalt --etc
or vice versa. If there is no such shortest path exist print -1.

Input Format:
-------------
Line-1: 3 space separated integers N, C & A, Number of cities, routes between the cities.
		number of concrete roads and number of asphalt roads
Next C lines: Two space separated integers, concrete road between city-i to city-j.		
Next A lines: Two space separated integers, asphalt road between city-i to city-j.		

Output Format:
--------------
Print the list of lengths, the shortest paths.


Sample Input-1:
---------------
4 2 1
0 1
2 3
1 2

Sample Output-1:
----------------
0 1 2 3

Sample Input-2:
---------------
4 2 1
1 0
2 3
1 2

Sample Output-2:
----------------
0 -1 -1 -1


Sample Input-3:
---------------
4 3 2
1 0
1 2
2 3
0 1
1 2

Sample Output-3:
----------------
0 1 2 -1

*/

import java.util.*;

class Solution{
    /*
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int c = s.nextInt();
        int a = s.nextInt();
        Map<Integer,List<Integer>> con = new HashMap<>();
        Map<Integer,List<Integer>> asp = new HashMap<>();
        for(int i=0;i<c;i++){
            int x = s.nextInt();
            int y = s.nextInt();
            if(!con.containsKey(x)) con.put(x,new ArrayList<>());
            con.get(x).add(y);
        }
        for(int i=0;i<a;i++){
            int x = s.nextInt();
            int y = s.nextInt();
            if(!asp.containsKey(x)) asp.put(x,new ArrayList<>());
            asp.get(x).add(y);
        }
        System.out.println(Arrays.toString(getDistance(n,con,asp)));
    }
    
    static int[] getDistance(int n,Map<Integer,List<Integer>> con,Map<Integer,List<Integer>> asp){
        int[] distv = new int[n];
        distv[0] = 0;
        // for initiating with concrete, k = 0
        // for initiating with asphalt, k = 1
        for(int k=0;k<2;k++){
            ArrayDeque<Integer> q = new ArrayDeque<>();
            q.offerLast(0);
            boolean[][] vis = new boolean[n][2];
            vis[0][k^0] = true;
            int i=0;
            while(!q.isEmpty()){
                int size = q.size();
                for(int j=0;j<size;j++){
                    int temp = q.pollFirst();
                    if(i%2 == k){
                        for(Integer nei : con.get(temp)){
                            if(vis[nei][i%2]) continue;
                            q.offerLast(nei);
                            vis[nei][i%2] = true;
                            distv[nei] = Math.min(distv[nei],i+1);
                        }
                    }
                    else{
                        for(Integer nei : asp.get(temp)){
                            if(vis[nei][i%2]) continue;
                            q.offerLast(nei);
                            vis[nei][i%2] = true;
                            distv[nei] = Math.min(distv[nei],i+1);
                        }
                    }
                }
                i++;
            }
        }
        return distv;
    }
    */
    
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int c = s.nextInt();
        int a = s.nextInt();
        int[][] con = new int[c][2];
        int[][] asp = new int[a][2];
        for(int i=0;i<c;i++){
            con[i][0] = s.nextInt();
            con[i][1] = s.nextInt();
        }
        for(int i=0;i<a;i++){
            asp[i][0] = s.nextInt();
            asp[i][1] = s.nextInt();
        }
        System.out.println(Arrays.toString(getDistanceVector(n,con,c,asp,a)));
    }
    
    static int[] getDistanceVector(int n,int[][] con,int c,int[][] asp,int a){
        int[] distv = new int[n];
        int[][] conn = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(conn[i],-100);
        }
        for(int[] e : con){
            conn[e[0]][e[1]] = 1;
        }
        for(int[] e : asp){
            if(conn[e[0]][e[1]] == 1) conn[e[0]][e[1]] = 0;
            else conn[e[0]][e[1]] = -1;
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,1});
        q.offer(new int[]{0,-1});
        int dist = 0;
        Arrays.fill(distv,Integer.MAX_VALUE);
        distv[0] = 0;
        Set<String> vis = new HashSet<>();
        while(!q.isEmpty()){
            int size = q.size();
            dist++;
            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                int ci = curr[0];
                int ro = curr[1];
                int opp = -ro;
                for(int j=1;j<n;j++){
                    if(conn[ci][j] == opp || conn[ci][j] == 0){
                        if(!vis.add(j+"-"+opp)) continue;
                        q.offer(new int[]{j,opp});
                        distv[j] = Math.min(distv[j],dist);
                    }
                }
            }
        }
        for(int i=1;i<n;i++){
            if(distv[i] == Integer.MAX_VALUE) distv[i] = -1;
        }
        return distv;
    }
}
