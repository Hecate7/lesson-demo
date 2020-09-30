package order.order_84;


import java.util.Arrays;
import java.util.Stack;

/**
 * 给定n个非负整数,用来表示柱形图中每个柱子的高度,每个柱子彼此相邻,且宽度为1
 * 求该柱形图中能够勾勒出的矩形的最大面积
 *
 * 枚举矩形的宽和高
 */
public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights){
        if (heights==null || heights.length==0) return 0;

        int maxArea = Integer.MIN_VALUE;
        for(int height = 0; height<heights.length; height++){
            int i=height, j=height;
            while (i>=0){
                if (heights[i]<heights[height]){
                    break;
                }
                if (i==0){
                    i--;
                    break;
                }
                i--;
            }

            while (j<heights.length){
                if (heights[j]<heights[height]){
                    break;
                }
                if (j==heights.length-1){
                    j++;
                    break;
                }
                j++;
            }

            maxArea = Math.max(maxArea, (j-1-i)*heights[height]);
        }
        return maxArea;
    }


    /**
     *
     * 高h = heights[i]
     * 向左右两边扩展,找到左右两侧最近的高度小于h的柱子
     *
     * 如何找到i左侧且最近的小于h的柱子?
     * 两根柱子j0,j1，如果j0<j1，并且heights[j0]>=heights[j1]
     * 针对i(j0<j1<i)，j0一定不会是i左侧且最近小于h的柱子
     *
     * 对数组从左向右进行遍历，维护一个数据结构(可能作为答案)，其中按照从小到大的顺序存放一些j值
     * [j0, j1, ... , js] -> heights[j0]<heights[j1]<...<heights[js]（从左往右遍历，j0<j1<...<js）
     * (假设数组中存在jp, jq不满足heights[jp]<heights[jq]， 即heights[jp]>=heights[jq](jp<jq)，那么在选择i左侧最近小于h的柱子时，jq会挡住jp，jp就不可能作为答案)
     *
     * 当我们枚举到第i根柱子时，必然有：
     * [j0, j1, ..., ji, i, ji1, ..., js] -> height[j0]<height[j1]<...<heights[ji]<heights[i]<heights[ji1]<...<heights[js]
     * 当我们枚举到第i+1根柱子时，i也成了j值，因此i会被放入到数据结构中。所以所有heights[i]<heights[j]的j都不能再做为答案，需要被移除
     * (ji1, ..., js)
     *
     * 所以在我们枚举第i根柱子的时候，将所有高度大于heights[i]的j都从数据结构中移除，剩下的j值中最高的就是i左侧且最近小于h的柱子
     * 当位置i被弹出栈时，说明遍历的位置i0的高度小于等于height[i],且i0与i之间没有其他高度小于heights[i]的柱子
     *
     * 数据结构-》栈
     * 1.栈中存放j值，从栈底到栈顶，j的值严格单调递增，同时对应的heights[j]值也递增
     * 2.枚举到第i根柱子时，从栈顶不断移除height[j]>=height[i]的j值。移除完毕后，栈顶的j值就是i左侧最近的高度小于h的柱子
     * 2.1.如果我们移除了栈中的所有元素，说明i左侧的柱子高度都大于h，那么j值认定为-1【哨兵】
     * 3.再将i放入栈顶
     *
     * @param heights
     * @return
     */
    public int largestRectangleAreaSolution(int[] heights){
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        //哨兵
        Arrays.fill(right, n);

        Stack<Integer> mono_stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]){
                right[mono_stack.peek()]=i;
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty())?-1:mono_stack.peek();
            mono_stack.push(i);
        }

        mono_stack.clear();
//        for (int i = n-1; i >= 0 ; i--) {
//            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]){
//                mono_stack.pop();
//            }
//            right[i] = mono_stack.isEmpty()?n:mono_stack.peek();
//            mono_stack.push(i);
//        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i]-left[i]-1)*heights[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        LargestRectangleArea largestRectangleArea = new LargestRectangleArea();
        int[] area = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea.largestRectangleArea(area));
    }
}
