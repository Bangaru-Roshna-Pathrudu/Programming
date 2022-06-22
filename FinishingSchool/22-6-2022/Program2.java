/*
Math Challenge(str) take the str parameter being passed and determine if there
is some substring K that can be repeated N > 1 times to produce the input string
exactly as it appears. Your program should return the longest substring K, and
if there is none it should return "Not Possible".

Input Format:
-------------
A string str, consists of lowercase alphabet.

Output Format:
--------------
Print the longest substring K.


Sample Input-1:
---------------
abcababcababcab

Sample Output-1:
----------------
abcab


Sample Input-2:
---------------
ababababababababab

Sample Output-2:
----------------
ababab


Sample Input-3:
---------------
abcxabc

Sample Output-3:
----------------
Not Possible


*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        System.out.println(getLongestSubstring(str));
    }
    
    static String getLongestSubstring(String str){
        int l = str.length()/2;
        for(int i=l;i>=1;i--){
            String subs = str.substring(0,i);
            if(isOpt(subs,str)) return subs;
        }
        return "Not Possible";
    }
    
    static boolean isOpt(String sub,String str){
        int j = 0,l = sub.length();
        for(int i=0;i<str.length();i++){
            j = j%l;
            if(sub.charAt(j) != str.charAt(i)) return false;
            j++;
        }
        return (j==l);
    }
}
