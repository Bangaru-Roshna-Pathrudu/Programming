/*
A new online video game has been released, and in this video game, there are 
15-minute rounds scheduled every quarter-hour period. This means that at HH:00,
HH:15, HH:30 and HH:45, a new round starts, where HH represents an integer 
number from 00 to 23. A 24-hour clock is used, so the earliest time in the day 
is 00:00 and the latest is 23:59.

Given two strings startTime and finishTime in the format "HH:MM" representing 
the exact time you started and finished playing the game, respectively, 
calculate the number of full rounds that you played during your game session.

For example, if startTime = "05:20" and finishTime = "05:59" this means you 
played only one full round from 05:30 to 05:45. You did not play the full round 
from 05:15 to 05:30 because you started after the round began, and you did not 
play the full round from 05:45 to 06:00 because you stopped before the round 
ended. If finishTime is earlier than startTime, this means you have played 
overnight (from startTime to the midnight and from midnight to finishTime).

Return the number of full rounds that you have played if you had started 
playing at startTime and finished at finishTime.


Input Format:
-------------
Two space separated strings, startTime and finishTime.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
12:01 12:44

Sample Output-1:
----------------
1

Explanation: 
------------
You can play 1 game round from 12:15 to 12:30 from 12:01 to 12:44


Sample Input-2:
---------------
20:00 06:00

Sample Output-2:
----------------
40

Explanation:
------------
You can play 16 game rounds from 20:00 to 00:00 and 24 game rounds from 00:00 to 06:00. 


*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String[] slot = s.nextLine().split(" ");
        System.out.println(getTotalGames(slot));
    }
    
    static int getTotalGames(String[] slot){
        int hen = Integer.parseInt(slot[1].substring(0,2));
        int hst = Integer.parseInt(slot[0].substring(0,2));
        int mst = Integer.parseInt(slot[0].substring(3));
        int men = Integer.parseInt(slot[1].substring(3));
        int smin = hst*60 + mst;
        int emin = hen*60 + men;
        if(emin < smin){
            emin += 1440;
        }
        while(smin%15 != 0) smin++;
        while(emin%15 != 0) emin--;
        return (emin-smin)/15;
    }
}

/*
import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String[] slot = s.nextLine().split(" ");
        System.out.println(getTotalGames(slot));
    }
    
    static int getTotalGames(String[] slot){
        int total = 0;
        /*
        String nearst = getRound(slot[0]);
        String nearen = getRound(slot[1]);
        */
        int hen = Integer.parseInt(slot[1].substring(0,2));
        int hst = Integer.parseInt(slot[0].substring(0,2));
        int mst = Integer.parseInt(slot[0].substring(3));
        int men = Integer.parseInt(slot[1].substring(3));
        if(hen == hst && mst < men){
            total += (men-mst)/15;
        }
        else if(hen == hst && men < mst){
            total += 96 - (mst - men)/15;
        }
        else if(hst > hen){
            total += (24-hst)/4;
            total -= 4 - (60 - mst)/15;
            total += hen*4;
            total += men/15;
        }
        else{
            total += (hen-hst)*4;
            total -= (60-mst)/15;
            total += men/15;
        }
        return total;
        /*
        System.out.println(hst+"-"+hen+" "+mst+"-"+men);
        System.out.println(nearst+" "+nearen);
        if(slot[0].compareTo(slot[1]) < 0){
            int len = hen - hst;
            total += len/4;
            System.out.println(total+"if");
            total += (men-mst)/15;
            return total;
        }
        else{
            int l1 = 24 - hst;
            int l2 = hen;
            total += (l1+l2)/4;
            System.out.println(total+"else");
            total += (60 - mst)/15;
            System.out.println(total+"fst");
            total += men/15;
            System.out.println(total+"lst");
            return total;
        }
        */
        
    }
    /*
    static String getRound(String str){
        return str.substring(0,3)+"00";
    }
    */
}
*/
