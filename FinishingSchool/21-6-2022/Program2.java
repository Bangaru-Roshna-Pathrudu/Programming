/*
In a garden, there is a row of plants. The gardener need to water them regularly.
In the row of plants, some are empty places some are plants. you need to setup 
the watering kits to water the row of plants at the empty places. A watering kit
can supply water to its adjacent plants, i.e., if the watering kit is at 
i-th position it can water the plants ar 'i+1'-th and 'i-1'-th  positions.

You are given a string 'plants', consists of two characters only [P,E], where P 
indiactes plant and E indicates empty place.

Your task is to return the minimum number of watering kits needed so that 
for every plant, the gardener can supply the water to all the plants in that 
row OR -1 if it is impossible.


Input Format:
-------------
A string, consists of only two characters P and E

Output Format:
--------------
Print an integer result, the minimum num of watering kits.


Sample Input-1:
---------------
PEEEPEP

Sample Output-1:
----------------
2

Explanation: 
------------
You can setup watering kits at index-1, index-5, so all the 3 plants gets water.


Sample Input-2:
---------------
PEPEEPP

Sample Output-2:
----------------
-1

Explanation: 
------------
No empty place after the last plant in the row, so retrun -1.


*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String row = s.nextLine();
        System.out.println(waterKitsRequired(row));
    }
    
    static int waterKitsRequired(String row){
        StringBuilder sb = new StringBuilder(row);
        int l = row.length(),count=0;
        for(int i=0;i<l;i++){
            if(row.charAt(i) == 'E'){
                if(i-1>=0 && i+1<l && sb.charAt(i-1) == 'P' && sb.charAt(i+1) == 'P'){
                    sb.setCharAt(i+1,'#');
                    sb.setCharAt(i-1,'#');
                    count++;
                }
            }
        }
        for(int i=0;i<l;i++){
            if(row.charAt(i) == 'E'){
                if(i-1>=0 && sb.charAt(i-1) == 'P'){
                    sb.setCharAt(i-1,'#');
                    count++;
                }
            }
        }
        for(int i=0;i<l;i++){
            if(row.charAt(i) == 'E'){
                if(i+1<l && sb.charAt(i+1) == 'P'){
                    sb.setCharAt(i+1,'#');
                    count++;
                }
            }
        }
        if(sb.indexOf("P") == -1) return count;
        return -1;
    }
}
