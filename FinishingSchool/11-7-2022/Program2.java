/*
Consider a pair of integers, (a,b). The following operations can be performed 
on (a,b) in any order, zero or more times:
	- (a,b) -> ( a+b, b )
	- (a,b) -> ( a, a+b )

For example, starting with (1,1), perform the operation (1, 1+1) to get (1,2), 
perform the operation (1+2, 2) to get (3,2), and perform the operation (5,2). 
Alternatively the first operation could be (1+1, 1) to et (2,1) and so on.

Your task is to build a function must return a string that denotes whether you 
can convert (a,b) to (c,d) by performing zero or more operations specified 
above? or not. 

If it is possible, return true, otherwise false.

NOTE: 
1<= a,b,c,d <= 1000

Input Format:
-------------
Line-1: Two space separated integers, a,b
Line-2: Two space separated integers, c,d

Output Format:
--------------
Return a boolean value.


Sample Input-1:
---------------
1 2
5 4

Sample Output-1:
----------------
true


Sample Input-2:
---------------
2 3
10 7

Sample Output-2:
----------------
false

*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] start = sc.nextLine().split(" ");
        String[] end = sc.nextLine().split(" ");
        int sf = Integer.parseInt(start[0]);
        int sl = Integer.parseInt(start[1]);
        int ef = Integer.parseInt(end[0]);
        int el = Integer.parseInt(end[1]);
        System.out.println(isConvertable(sf,sl,ef,el));
    }
    
    static boolean isConvertable(int sf,int sl,int ef,int el){
        Map<String,Boolean> memo = new HashMap<>();
        return helper(sf+sl,sl,ef,el,memo) | helper(sf,sf+sl,ef,el,memo);
    }
    
    static boolean helper(int a1,int a2,int b1,int b2,Map<String,Boolean> memo){
        if(a1 == b1 && a2 == b2) return true;
        if(a1 > b1 || a2 > b2) return false;
        String key = a1+"-"+a2;
        if(memo.containsKey(key)) return memo.get(key);
        memo.put(key,helper(a1+a2,a2,b1,b2,memo) | helper(a1,a1+a2,b1,b2,memo));
        return memo.get(key);
    }
}
