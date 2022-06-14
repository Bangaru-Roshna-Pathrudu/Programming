/*
Mr. Parandamayya is working with Strings.
He is given a String S. He has to find the palindromes in S, 
A palindrome can be a substring of S (Strictly substrings only, not subsequences).

Your task is to find the count the number of palindromes can be formed from S.

NOTE: Count each occurence of palindromes if duplicate substrings found. 

Input Format:
-------------
A string S

Output Format:
--------------
Print an integer, number of palindromes.


Sample Input-1:
---------------
divider

Sample Output-1:
----------------
9

Explanation:
-------------
Palindromes are d, i, v, i, d, e, r, ivi, divid

Sample Input-2:
---------------
abcdef

Sample Output-2:
----------------
6

Explanation:
-------------
Palindromes are a, b, c, d, e, f.

*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        System.out.println(countOfPalindromicSubstrings(str));
    }
    
    static int countOfPalindromicSubstrings(String str){
        int count = 0;
        for(int k=0;k<str.length();k++){
            int i=k,j=k;
            while(i>=0 && j<str.length() && str.charAt(i)==str.charAt(j)){
                count++;
                i--;
                j++;
            }
            i=k;
            j=k+1;
            while(i>=0 && j<str.length() && str.charAt(i)==str.charAt(j)){
                count++;
                i--;
                j++;
            }
        }
        return count;
    }
}
