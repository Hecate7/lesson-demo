package order.order_495;

public class TeemoAttacking {
    public static void main(String[] args) {
        int[] timeSeries = {1,2};
        System.out.println(findPoisonedDuration(timeSeries, 2));
    }

    public static int findPoisonedDuration(int[] timeSeries, int duration){
        int poisoned = 0;

        for (int i = 0; i < timeSeries.length; i++) {
            if (i==0 || timeSeries[i]>=timeSeries[i-1]+2){
                poisoned += duration;
            } else {
                poisoned += timeSeries[i] - timeSeries[i-1];
            }
        }

        return poisoned;

    }
}
