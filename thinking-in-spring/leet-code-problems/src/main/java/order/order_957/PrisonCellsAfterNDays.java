package order.order_957;

import java.util.HashMap;
import java.util.Map;

public class PrisonCellsAfterNDays {
    public static void main(String[] args) {
        PrisonCellsAfterNDays cell = new PrisonCellsAfterNDays();
        int[] cells = {0,1,0,1,1,0,0,1};
        cell.prisonAfterNDays(cells, 7);
    }


    /**
     * 总共有八间牢房 -> 最多只有8^2=256种可能的状态,状态会快速的形成一个循环,记录当状态出现循环下的周期然后跳过t的倍数的天数
     * @param cells
     * @param N 1<=N<=10^9 ->存在超时的可能
     * @return
     */
    public int[] prisonAfterNDays(int[] cells, int N){
        int PRISON_SIZE = cells.length;
        int MID_PRISON_SIZE = cells.length - 2;
        Map<Integer, Integer> seen = new HashMap<>();

        int state = 0;
        for (int i = 0; i < PRISON_SIZE; i++) {
            if (cells[i] > 0){
                state ^= 1<<1;
            }
        }

        while (N > 0){
            if (seen.containsKey(state)){
                N %= seen.get(state)-N;
            }
            seen.put(state, N);

            if (N >= 1){
                N--;
                state = nextDay(state);
            }
        }

        int[] ans = new int[PRISON_SIZE];
        for (int i = 0; i < PRISON_SIZE; i++) {
            if (((state >> i) & 1) > 0){
                ans[i] = 1;
            }
        }
        return ans;

        //超时
//        for (int i = 0; i < N; i++) {
//            cells = prisonAfterDays(cells);
//        }
//        return cells;
    }

    public int nextDay(int state){
        int ans = 0;

        for (int i = 0; i <= 6; i++) {
            if (((state >> (i-1)) & 1) == (state >> (i+1)&1)){
                ans ^= 1<<i;
            }
        }
        return ans;
    }

    public static int[] prisonAfterDays(int[] cells){
        int[] array = new int[cells.length];
        for (int i = 1; i < cells.length-1; i++) {
            if (cells[i-1] == cells[i+1]){
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
        return array;
    }
}
