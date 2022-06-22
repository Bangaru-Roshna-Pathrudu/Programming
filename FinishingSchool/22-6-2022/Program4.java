/*
Mr Malhotra is given a word W consisting of lowercase alphabet,and an integer I.
A substring S of W is said to be an ECS string, if S obeys the following rule:
    - each distinct alphabet in S, appears exactly I times in S.

Your task is to help Mr Malhotra to return the number of ECS strings in W.

Input Format:
-------------
Line-1: A String W
Line-2: An integer I

Output Format:
--------------
Print an integer result


Sample Input-1:
---------------
abbabbaba
2

Sample Output-1:
----------------
5

Explanation: 
------------
The ECS strings are 'abba' for 2 times, 'bb' for 2 times and 'baba' for 1 time


Sample Input-2:
---------------
pqrs
1

Sample Output-2:
----------------
10

*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String word = s.nextLine();
        int n = s.nextInt();
        System.out.println(getECSCount(word,n));
    }
    
    static int getECSCount(String word,int n){
        int wsize = n,count=0,len = word.length();
        while(wsize<=word.length()){
            int[] occ = new int[26];
            for(int i=0;i<wsize;i++){
                char ch = word.charAt(i);
                occ[ch-'a']++;
            }
            int f=0;
            for(int i=0;i<26;i++){
                if(occ[i]!=n && occ[i]!=0){
                    f++;
                    break;
                }
            }
            if(f == 0) count++;
            for(int k=1;k<len-wsize+1;k++){
                occ[word.charAt(k-1)-'a']--;
                occ[word.charAt(k+wsize-1)-'a']++;
                f=0;
                for(int i=0;i<26;i++){
                    if(occ[i] != n && occ[i]!=0){
                        f++;
                        break;
                    }
                }
                if(f == 0) count++;
            }
            wsize += n;
        }
        return count;
    }
}
