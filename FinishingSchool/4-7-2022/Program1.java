/*
Vihaan is given a list of words[]. 
He is asked to create a method which returns the numbers of characters in a word 
formed from long lasting frequent posteriority.

Posteriority is the word formed from the original word with few characters removed
without modifying the corresponding order of the left over characters.

An uncommon posteriority between the list of words is a word that is a posteriority
of one word but not the others.

Your task is to find the longest uncommon posteriority of the list of words.
Return 0 if no uncommon posteriority.


Input Format:
-------------
Space separated strings words[]

Output Format:
--------------
Print an integer, the length of longest uncommon prosperity.


Sample Input-1:
---------------
mom rar ama

Sample Output-1:
----------------
3


Sample Input-2:
---------------
ppp ppp pp

Sample Output-2:
----------------
-1

*/

import java.util.*;

class Solution{
    public static void main(String[] agrs){
        Scanner s = new Scanner(System.in);
        String[] words = s.nextLine().split(" ");
        System.out.println(longestUncommonSubsequenceLength(words));
    }
    
    static int longestUncommonSubsequenceLength(String[] w){
        int len = -1;
        for(int i=0;i<w.length;i++){
            boolean isUnique = true;
            for(int j=0;j<w.length;j++){
                if(i!=j && isSubsequence(w[i],w[j])){
                    isUnique = false;
                    break;
                }
            }
            if(isUnique) len = Math.max(len,w[i].length());
        }
        return len;
    }
    
    static boolean isSubsequence(String w1,String w2){
        if(w1.length() > w2.length()) return false;
        int i=0,j=0;
        while(i<w1.length() && j<w2.length()){
            if(w1.charAt(i) == w2.charAt(j)){
                i++;
            }
            j++;
        }
        return i == w1.length();
    }
}
