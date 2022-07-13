/*
Ravi is playing with strings.Given Three alphabets [a,b,c] , ravi has to 
make strings such that no two adjacents alphabets are same.

For example, He can make strings as "ab", "acb", "b" and "cbabcabcb" which 
are acceptable.where as the strings "bb", "bcc" and "aabbc" are not acceptable.

Given two integers N and L, Ravi made a list of all acceptable strings of 
length N sorted in lexicographical order.

Return the Lth string of this list or return an empty string if there are less 
than L acceptable strings of length N.

Input Format:
-------------
Line-1: Two space separated integers N and L.

Output Format:
--------------
Print a string result.


Sample Input-1:
---------------
2 3

Sample Output-1:
----------------
ba

Explanation:
-------------
Strings in lexigraphical order are ab,ac,ba,bc,ca,cb. and 3rd one is ba.


Sample Input-2:
---------------
3 4

Sample Output-2:
----------------
acb

Explanation:
------------
Strings in lexigraphical order are aba,abc,aca,acb,bab....

*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(getString(n,k));
    }
    
    static String getString(int n,int k){
        List<String> list = new ArrayList<>();
        helper(n,"",list);
        if(list.size() < k) return new String("");
        return list.get(k-1);
    }
    
    static void helper(int n,String curr,List<String> list){
        if(n == 0){
            list.add(curr);
            return;
        }
        int l = curr.length();
        if(l==0 || curr.charAt(l-1) != 'a') helper(n-1,curr+"a",list);
        if(l==0 || curr.charAt(l-1) != 'b') helper(n-1,curr+"b",list);
        if(l==0 || curr.charAt(l-1) != 'c') helper(n-1,curr+"c",list);
    }
}
