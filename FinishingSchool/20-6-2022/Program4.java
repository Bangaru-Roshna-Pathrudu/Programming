/*
Konda reddy purchased a plot with area 'a' in "Suvarna bhoomi infra developers 
project". After 2 years he wants to sell this property and want to purchase
same area  in "Sai surya developers project". 
In the new project there are plots only in square space and he can only choose
2 plots.

Your task is to help Konda reddy whether there exist 2 plots with sides 
as p1,p2 such that p1^2 + p2^2 =a.

Input Format:
-------------
Line-1: An integer a, represents area of the plot.

Output Format:
--------------
return true or false


Sample Input-1:
---------------
25

Sample Output-1:
----------------
true

Explanation:
------------
He can purchase two plots with sides as 5 each.


Sample Input-2:
---------------
169

Sample Output-2:
----------------
true

Explanation:
------------
He can purchase two plots with sides as 12 and 5 (12^2 + 5^2 = 169).

*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        System.out.println(areAvailable(a));
    }
    
    static boolean areAvailable(int a){
        int i=1,j=(int)Math.sqrt(a);
        while(i<=j){
            long sum = (i*i) + (j*j);
            if(sum == a) return true;
            else if(sum > a){
                j = j - 1;
            }
            else{
                i = i + 1;
            }
        }
        return false;
    }
}
