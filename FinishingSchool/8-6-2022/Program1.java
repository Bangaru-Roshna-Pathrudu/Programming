/*
Sampoornesh Babu is working with Strings.
He is trying to form a palindrome using two strings P and Q.
The rules to form the palindrome are as follows:
	- Divide the strings P and Q into two parts, and length of P and Q are same.
	- Division of P and Q should be done at same index position.
	- After Division P -> P1 + P2 and Q -> Q1 + Q2, where + indicates concatenation.
	- Now, check whether P1 + Q2 or Q1 + P2 forms a palindrome or not.
	- if palindrome is formed print 'true', otherwise 'false'. 

For Example: 'job' can be divided in the following ways:
""+"job", "j"+"ob",  "jo"+"b", "job"+"".

Your task is to help Sampoornesh Babu to find whether palindrome can be 
formed with the strings P and Q.

Input Format:
-------------
Two space separated strings P and Q

Output Format:
--------------
Print a boolean value, whether can you form a palindrome or not.


Sample Input-1:
---------------
mortal carrom

Sample Output-1:
----------------
true

Explanation:
------------
Divide P="mortal" and Q="carrom" at index 3 as follows:
    P -> "mor" + "tal", P1 = "mor" and P2 = "tal"
    Q -> "car" + "rom", Q1 = "car" and Q2 = "rom"

P1 + Q2 = "morrom" is a palindrome,so print true.


Sample Input-2:
---------------
romans carrom

Sample Output-2:
----------------
false

*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String s1 = s.next();
        String s2 = s.next();
        System.out.println(isPalindromeFormed(s1,s2));
    }
    /*
    static boolean isPalindromeFormed(String s1,String s2){
        int len = Math.min(s1.length(),s2.length());
        StringBuilder sb1 = new StringBuilder(s1);
        StringBuilder sb2 = new StringBuilder(s2);
        if(sb1.toString().equals(sb1.reverse().toString()) || sb2.toString().equals(sb2.reverse().toString())){
            return true;
        }
        for(int i=1;i<len;i++){
            StringBuilder sb3 = new StringBuilder();
            sb3.append(s1.substring(0,i));
            sb3.append(s2.substring(i));
            if(sb3.toString().equals(sb3.reverse().toString())) return true;
            sb3.delete(0,sb3.length());
            sb3.append(s2.substring(0,i));
            sb3.append(s1.substring(i));
            if(sb3.toString().equals(sb3.reverse().toString())) return true;
        }
        return false;
    }
    */
    
    static boolean isPalindromeFormed(String s1,String s2){
        return select(s1,s2) || select(s2,s1);
    }
    
    static boolean select(String s1,String s2){
        int i=0,j=s2.length()-1;
        while(i<=j && s1.charAt(i)==s2.charAt(j)){
            i++;
            j--;
        }
        return isPalindrome(s1,i,j) || isPalindrome(s2,i,j);
    }
    
    static boolean isPalindrome(String str,int i,int j){
        while(i<j && str.charAt(i)==str.charAt(j)){
            i++;
            j--;
        }
        return i>=j;
    }
}
