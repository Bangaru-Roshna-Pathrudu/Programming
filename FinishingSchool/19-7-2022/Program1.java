/*

There are numerous possible combinations of HTML colour codes, and each one is 
given a specific identification number. Each codes[i] in the list, codes[], 
is an HTML colour code that was chosen by the web designer. The list may 
contain duplicate codes.

The web designer's customer made the decision to eliminate P number of 
consecutive codes from the list. However, the web designer wants to preserve as 
many distinctive colour codes as he can. Find out how many unique colour codes 
the web designer can preserve, and print the count of unique color codes.


Input Format:
-------------
Line-1: Comma separated integers, codes[], HTML color codes
Line-2: An integer P.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
2,3,2,6,3,3,7,1
4

Sample Output-1:
----------------
4

Explanation: 
------------
The unique color codes he can preserve are, [2,3,7,1]
by removing [2,6,3,3].


Sample Input-2:
---------------
1,2,1,2,3,3,2,1,2,1
6

Sample Output-2:
----------------
2

Explanation: 
------------
The unique color codes he can preserve are, [2,1,2,1] or [1,2,1,2]
by removing 6 contiguous codes.
*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String codes[] = sc.nextLine().split(",");
        int d = sc.nextInt();
        System.out.println(getMostVarieties(codes,d));
    }
    
    static int getMostVarieties(String[] codes,int d){
        Map<String,Integer> map = new HashMap<>();
        int l = codes.length,max = 0;
        for(int i=0;i<l;i++){
            map.put(codes[i],map.getOrDefault(codes[i],0)+1);
        }
        for(int i=0;i<d;i++){
            map.put(codes[i],map.get(codes[i])-1);
            if(map.get(codes[i]) == 0) map.remove(codes[i]);
        }
        max = Math.max(max,map.size());
        for(int i=1;i<=l-d;i++){
            String a = codes[i-1];
            String r = codes[i+d-1];
            map.put(a,map.getOrDefault(a,0)+1);
            map.put(r,map.get(r)-1);
            if(map.get(r) == 0) map.remove(r);
            max = Math.max(max,map.size());
        }
        return max;
    }
}
