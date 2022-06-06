/*
Keshav Memorial Group of Institutions, planning to conduct Mock-Interviews 
for Finishing School Students in KMIT and NGIT Colleges.

There are N students to participate in the interview,where N is an even number. 
You will be given an array of tariffs as fare[], 
where fare[a]=[fareToReachKmit-a, fareToReachNgit-a],
 - fareToReachKmit-a indicates cab fare for Student-a to reach KMIT campus.
 - fareToReachNgit-a indicates cab fare for Student-a to reach NGIT campus.

Keshav Memorial Management decided to refund the cab fare to every student. 

Your task is to help the management to find the minimum total fare to be paid 
by all the students to attend the interviews in KMIT and NGIT, such that both 
the colleges should conduct interviews for equal number of students.

Input Format:
-------------
Line-1: An integer N, number of students.
Next N lines: Two space separated integers, fares to reach KMIT and NGIT. 

Output Format:
--------------
Print an integer, minimum fare paid by N students(to be refunded).


Sample Input-1:
---------------
6
10 75
35 120
105 45
80 110
125 85
65 100

Sample Output-1:
----------------
350

Explanation:
------------
Student-1 attended interview in KMIT with fare - 10.
Student-2 attended interview in KMIT with fare - 35.
Student-3 attended interview in NGIT with fare - 45.
Student-4 attended interview in NGIT with fare - 110.
Student-5 attended interview in NGIT with fare - 85.
Student-6 attended interview in KMIT with fare - 65.
3 students attended in KMIT and 3 students attended in NGIT.
So, the total minimum fare is to be refunded 350.


Sample Input-2:
---------------
6
159 635
495 67
784 571
221 243
783 134
524 476

Sample Output-2:
----------------
1676
*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] fare = new int[n][2];
        for(int i=0;i<n;i++){
            fare[i][0] = s.nextInt();
            fare[i][1] = s.nextInt();
        }
        System.out.println(getMinimumFare(fare,n));
    }
    
    static int getMinimumFare(int[][] fare,int n){
        Arrays.sort(fare,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                if(Math.abs(a[0]-a[1])>Math.abs(b[0]-b[1])) return -1;
                return 1;
            }
        });
        int ck=0,cn=0,minFare = 0;
        for(int i=0;i<n;i++){
            if(ck == n/2){
                minFare += fare[i][1];
            }
            else if(cn == n/2){
                minFare += fare[i][0];
            }
            else{
                if(fare[i][0]<fare[i][1]){
                    ck++;
                    minFare += fare[i][0];
                }
                else{
                    cn++;
                    minFare += fare[i][1];
                }
            }
        }
        return minFare;
    }
}
