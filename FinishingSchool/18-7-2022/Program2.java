/*
Mr Gnanesh is working with words. He has given a list of words. 
Each word in the list contains only two lowercase letters [a-z].

He wants to create biggest word BW, by concatenating words from the list, which 
is a palindrome too. He is allowed to use each word from the list atmost once.

Return the length of the biggest word can be formed using the list.
If it is impossible to create such word, return 0.

Input Format:
-------------
Space separated strings, words[], two letter words.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
ab ba dd

Sample Output-1:
----------------
6

Explanation: 
------------
The biggest word is, ab,dd,ba => abddba, which is a palindrome.


Sample Input-2:
---------------
pq rs sr mk km pq

Sample Output-2:
----------------
8

Explanation: 
------------
The biggest word is, rs,sr,mk,km => rsmkkmsr or mkrssrkm..etc, 
which is a palindrome.


Sample Input-3:
---------------
aa bb cc

Sample Output-3:
----------------
2

*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] st = sc.nextLine().split(" ");
        System.out.println(getPalindromeLength(st));
    }
    /*
    static int getPalindromeLength(String[] st){
        List<String> list = new ArrayList<>(Arrays.asList(st));
        int ref=0,sym=0;
        for(String s : list){
            if(isReflexive(s)){
                ref++;
            }
            else if(isSymmetric(s,list)){
                sym++;
            }
        }
        sym *= 2;
        return (ref > 0)?(sym+2):(sym);
    }
    
    static boolean isReflexive(String s){
        return s.charAt(0)==s.charAt(1);
    }
    
    static boolean isSymmetric(String s,List<String> list){
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return list.contains(sb.toString());
    }
    */
    static int getPalindromeLength(String[] st){
        Map<String,Integer> map = new HashMap<>();
        int sym = 0, length = 0;
        for(String s : st){
            if(!map.containsKey(s)) map.put(s,0);
            if(s.charAt(0) == s.charAt(1)){
                if(map.get(s) > 0){
                    sym--;
                    map.put(s,map.get(s)-1);
                    length += 4;
                }
                else{
                    map.put(s,map.get(s)+1);
                    sym++;
                }
            }
            else{
                StringBuilder sb = new StringBuilder(s);
                String sd = sb.reverse().toString();
                if(map.containsKey(sd) && map.get(sd) > 0){
                    length += 4;
                    map.put(sd,map.get(sd)-1);
                }
                else{
                    map.put(s,map.get(s)+1);
                }
            }
        }
        if(sym > 0) length += 2;
        return length;
    }
}
