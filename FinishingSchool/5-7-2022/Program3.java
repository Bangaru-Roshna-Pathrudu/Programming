/*
A transitive law is "If a == b and b == c, then a == c"
Which also says "If a == b and b != c, then a != c"

You will be given a list of strings relations[], i.e, like p==q or p!=q.
Your task is to find out whether all the relations follow the transitive law or not.
If all of them followed return true, otherwise return false.

Input Format:
-------------
Space separated strnigs, list of relations

Output Format:
--------------
Print a boolean value, whether transitive law is obeyed or not.


Sample Input-1:
---------------
a==b c==d c!=e e==f

Sample Output-1:
----------------
true


Sample Input-2:
---------------
a==b b!=c c==a

Sample Output-2:
----------------
false


Sample Input-3:
---------------
a==b b==c c!=d d!=e f==g g!=d

Sample Output-3:
----------------
true

*/

import java.util.*;

class Solution{
    
    static int[] par;
    
    static int find(int v){
        while(par[v] >= 0){
            v = par[v];
        }
        return v;
    }
    
    static void union(int u,int v){
        u = find(u);
        v = find(v);
        if(u != v) par[u] = v;
    }
    
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String[] rel = s.nextLine().split(" ");
        System.out.println(isTransitive(rel));
    }
    
    static boolean isTransitive(String[] rel){
        HashMap<Character,Integer> hm = new HashMap<>();
        int elec = 0;
        for(int i=0;i<rel.length;i++){
            char l = rel[i].charAt(0);
            char r = rel[i].charAt(3);
            if(!hm.containsKey(l)) hm.put(l,elec++);
            if(!hm.containsKey(r)) hm.put(r,elec++);
        }
        par = new int[elec];
        Arrays.fill(par,-1);
        for(String r : rel){
            if(r.charAt(1) == '='){
                int il = hm.get(r.charAt(0));
                int ir = hm.get(r.charAt(3));
                union(il,ir);
            }
        }
        for(String r : rel){
            if(r.charAt(1) == '!'){
                int il = hm.get(r.charAt(0));
                int ir = hm.get(r.charAt(3));
                if(find(il) == find(ir)) return false;
            }
        }
        return true;
    }
}
