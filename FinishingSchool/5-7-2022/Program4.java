/*
Gopal would like to go on Tour, and planned a schedule.
Airport authority has created a new way of issuing tickets.
Gopal purchased a set of airline tickets, 
each ticket contains the 'departure from' and 'arrival to'.

Redesign the Gopal's tour schedule in an order.
Gopal intially must begin his tour from BZA.
Hence the tour schedule's start point should begin with BZA. 

You are given a list of flight tickets which Gopal has purchased.
Your task is to find out and return the tour schedule that has the least 
lexical order. Gopal must use all the tickets once and only once.

Note:
------
If there are multiple valid schedules, you should return the schedule 
that has the smallest lexical order when read as a single string. 
For example, the schedule ["BZA", "LGA"] has a smaller lexical order than ["BZA", "LGB"].

All airports are represented by three capital letters.
You may assume all tickets form at least one valid schedule.

Input Format:
-------------
Single Line of tickets separated by comma, and each ticket separated by space, 
Gopal's flight tickets.

Output Format:
--------------
Print the schedule, which is smallest lexical order of tour schedule.


Sample Input-1:
----------------
DEL HYD,BZA DEL,BLR MAA,HYD BLR

Sample Output-1:
--------------------
[BZA, DEL, HYD, BLR, MAA]


Sample Input-2:
------------------
BZA BLR,BZA CCU,BLR CCU,CCU BZA,CCU BLR

Sample Output-2:
------------------
[BZA, BLR, CCU, BZA, CCU, BLR]

*/

import java.util.*;

class Solution{
    
    static Map<String,List<String>> adj = new HashMap<>();
    static List<String> ans = new ArrayList<>();
    
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String[] t = s.nextLine().split(",");
        optTrip(t);
    }
    
    static void optTrip(String[] t){
        for(int i=0;i<t.length;i++){
            String[] tic = t[i].split(" ");
            if(!adj.containsKey(tic[0])) adj.put(tic[0],new ArrayList<>());
            adj.get(tic[0]).add(tic[1]);
        }
        for(Map.Entry<String,List<String>> m : adj.entrySet()){
            Collections.sort(m.getValue());
        }
        backtrack("BZA",0,t.length);
    }
    
    static void backtrack(String src,int l,int n){
        int curs = ans.size();
        if(curs == l) ans.add(src);
        else{
            ans.set(l,src);
        }
        if(l == n){
            System.out.println(ans);
            System.exit(0);
        }
        if(!adj.containsKey(src)) return;
        int size = adj.get(src).size();
        if(size == 1){
            String des = adj.get(src).remove(0);
            adj.remove(src);
            backtrack(des,l+1,n);
            adj.put(src,new ArrayList<>());
            adj.get(src).add(des);
        }
        else{
            for(int i=0;i<size;i++){
                String des = adj.get(src).remove(i);
                backtrack(des,l+1,n);
                adj.get(src).add(i,des);
            }
        }
    }
}
