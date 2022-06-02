import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int d = s.nextInt();
        int[] cost = new int[n];
        for(int i=0;i<n;i++) cost[i] = s.nextInt();
        System.out.println(getMaxPurchase(cost,d));
    }
    
    static int getMaxPurchase(int[] cost,int d){
        int count=0,i=0;
        Arrays.sort(cost);
        while(i<cost.length && cost[i]<=d){
            d -= cost[i];
            i++;
            count++;
        }
        return count;
        /*
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<cost.length;i++) pq.offer(cost[i]);
        while(!pq.isEmpty() && d>0 && pq.peek()<=d){
            d -= pq.poll();
            count++;
        }
        return count;
        */
    }
}
