package order.order_6;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class zigzagConversion {
    public String convert(String s, int numRows){
        if (numRows <=1 || s.length()<=numRows){
            return s;
        }

        List<String> rows = new ArrayList<>(numRows);
        int currentRow = 1;
        boolean goingDown = false;
        for (char ch : s.toCharArray()) {
            rows.set(currentRow-1, rows.get(currentRow-1)+ch);
            if (currentRow==1 || currentRow==numRows){
                goingDown = !goingDown;
            }
            currentRow += goingDown?1:-1;
        }

        String str="";
        for (String row : rows) {
            str+=row;
        }
        return str;
    }
}
