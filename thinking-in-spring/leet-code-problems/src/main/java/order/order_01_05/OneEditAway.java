package order.order_01_05;

public class OneEditAway {
    public static void main(String[] args) {
        OneEditAway oneEditAway = new OneEditAway();
        System.out.println(oneEditAway.oneEditAway("ab", "bc"));
    }

    public boolean oneEditAway(String first, String second){
        //设定length(first) >= length(second)
        if (first.length() < second.length()){
            return oneEditAway(second, first);
        }

        if (first.length()-second.length() > 1){
            return false;
        }

        int i=0, j=0;
        int count = 0;
        while (i<first.length() && j<second.length()){
            if (count > 1){
                return false;
            }

            if (first.charAt(i)==second.charAt(j)){
                i++;
                j++;
            } else {
                count++;
                if (first.charAt(i+1)!=second.charAt(j)){
                    //替换
                    i++;
                    j++;
                } else {
                    //删除/插入
                    i++;
                }
            }
        }

//        if (i)
        return true;

    }
}
