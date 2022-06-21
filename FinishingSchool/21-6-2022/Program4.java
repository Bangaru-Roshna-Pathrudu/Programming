/*
Mr Shravan is given a word W, and W cosists of lowercase alphabets only. 
Mr Shravan is interested to find the substring which is smallest in length 
the which occurs only once in the word W.

Your task is to help Mr Sharavan to return the length of the smallest 
substring of W according to the above statement.

Input Format:
-------------
A String W, consists of lowercase letters.

Output Format:
--------------
An integer result.


Sample Input-1:
---------------
abbaabab

Sample Output-1:
----------------
2


Sample Input-2:
---------------
rererer

Sample Output-2:
----------------
5


*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        System.out.println(smallestSubstringLength(str));
    }
    
    static int smallestSubstringLength(String str){
        int win = 1,l = str.length();
        while(win < l){
            String ss = str.substring(0,win);
            if(str.indexOf(ss) == str.lastIndexOf(ss)) return ss.length();
            for(int i=1;i<=l-win;i++){
                ss = str.substring(i,i+win);
                if(str.indexOf(ss) == str.lastIndexOf(ss)) return ss.length();
            }
            win++;
        }
        return str.length();
    }
}
