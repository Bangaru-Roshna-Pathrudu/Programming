/*
Xavier working on bitwise operations on integer elements.
He is trying to find the maximum XOR value of two elements.
You will be given a list of integers elements list[],
Your task is to findout the maximum XOR value of two elements 
from the given list.

Input Format:
-------------
Line-1: An integer N, number of elements
Line-2: N space separated integers, Arrays of elements.

Output Format:
--------------
Print an integer, max value of XOR value of two elements.


Sample Input-1:
---------------
3
5 9 14

Sample Output-1:
----------------
12

Explanation:
------------
XOR of 5 and 9


Sample Input-2:
---------------
5
34 23 62 73 35

Sample Output-2:
----------------
119


Sample Input-3:
---------------
6
12 23 31 65 76 43

Sample Output-3:
----------------
106

*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] num = new int[n];
        for(int i=0;i<n;i++) num[i] = s.nextInt();
        System.out.println(maximumXORValue(num));
    }
    
    static int maximumXORValue(int[] num){
        int ans = 0;
        int init = 0;
        for(int i=30;i>=0;i--){
            init = init | (1<<i);
            int temp = ans | (1<<i);
            Set<Integer> set = new HashSet<>();
            for(int j=0;j<num.length;j++) set.add(num[j]&init);
            for(Integer comp : set){
                if(set.contains(comp^temp)){
                    ans = temp;
                    break;
                }
            }
        }
        return ans;
    }
}
