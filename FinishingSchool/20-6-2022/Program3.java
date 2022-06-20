/*
Preethi is playing with strings. She is given 2 strings. 
Preethi can remove any number of characters from 2 strings such that 2 strings 
to be equal after removal (Sequence of characters shouldn't change).
Find the smallest ASCII sum possible for the removed characters.

Input Format:
-------------
Line-1: Two space seperated strings

Output Format:
--------------
return an integer , represents ASCII sum with the given constraints.

Sample Input-1:
---------------
treat create

Sample Output-1:
----------------
316

Explanation:
-------------
Remove 't' in string1 and 'c' and 'e' in string 2. so sum= 116+99+101=316


Sample Input-2:
---------------
interest pintrest

Sample Output-2:
----------------
213

Explanation:
-------------
Remove 'e' in string1 and p in string2. so sum=101+112=213

*/

import java.util.*;

class Solution{
    
    static Map<String,Integer> memo = new HashMap<>();
    
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String s1 = s.next();
        String s2 = s.next();
        System.out.println(minASCIIDeletionSum(s1,s2));
    }
    
    static int minASCIIDeletionSum(String s1,String s2){
        return helper(s1,s2,0,0);
    }
    
    static int helper(String s1,String s2,int ind1,int ind2){
        int sum = 0;
        if(ind1>=s1.length() && ind2>=s2.length()) return 0;
        if(ind1>=s1.length()){
            for(int i=ind2;i<s2.length();i++){
                sum += (int)s2.charAt(i);
            }
            return sum;
        }
        if(ind2 >= s2.length()){
            for(int i=ind1;i<s1.length();i++){
                sum += (int)s1.charAt(i);
            }
            return sum;
        }
        String key = ind1+"-"+ind2;
        if(memo.containsKey(key)) return memo.get(key);
        if(s1.charAt(ind1) == s2.charAt(ind2)){
            sum = helper(s1,s2,ind1+1,ind2+1);
            memo.put(key,sum);
            return memo.get(key);
        }
        sum = Math.min((int)s1.charAt(ind1)+helper(s1,s2,ind1+1,ind2),(int)s2.charAt(ind2)+helper(s1,s2,ind1,ind2+1));
        memo.put(key,sum);
        return memo.get(key);
    }
}
