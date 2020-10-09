package cn.com.pcalpha;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"   16
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"   16
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * 45
 * 3  4   5   6
 *
 * 22  12  24  80
 * 23 22  21  21
 *
 * (6+45)/3
 */
public class Q6_ZTransform {
    public static void main(String[] args) {
        String str = "LDREOEIIECIHNTSGJFALJFDLAFJDLAFJLAJFLAJFLAJSF";

        Solution solution = new Solution();
        System.out.println(solution.convert(str, 3));
    }


    static class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1) return s;

            int len = s.length();
            int numCols = len/2+3;
            char[][] array = new char[numRows][numCols];


            boolean colDirect = true;//行方向
            int curRowIndex = 0;
            int curColIndex = 0;
            for (int i = 0; i < len; i++) {

//                System.out.println(i+"_"+s.charAt(i));
//                System.out.println(curRowIndex+"_"+curColIndex);
                array[curRowIndex][curColIndex] = s.charAt(i);


                if (i != 0 && (curRowIndex % numRows == (numRows-1) || curRowIndex % numRows == 0)) {
                    colDirect = !colDirect;//方向反转
                }

                if (colDirect) {
                    curRowIndex++;
                } else {
                    curRowIndex--;
                    curColIndex++;
                }
            }

            for(int i=0;i<numRows;i++){
                for(int j=0;j<numCols;j++){
                    if(0==array[i][j]){
                        System.out.print(" ");
                    }
                    System.out.print(array[i][j]);
                }
                System.out.println();
            }

            StringBuilder sb = new StringBuilder();
            for(int i=0;i<numRows;i++){
                for(int j=0;j<numCols;j++){
                    if(0!=array[i][j]){
                        sb.append(array[i][j]);
                    }
                }
            }

            return sb.toString();
        }
    }


    static class Solution1 {
        public String convert(String s, int numRows) {

            if (numRows == 1) return s;

            List<StringBuilder> rows = new ArrayList<>();
            for (int i = 0; i < Math.min(numRows, s.length()); i++)
                rows.add(new StringBuilder());

            int curRow = 0;
            boolean goingDown = false;

            for (char c : s.toCharArray()) {
                rows.get(curRow).append(c);
                if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
                curRow += goingDown ? 1 : -1;
            }

            StringBuilder ret = new StringBuilder();
            for (StringBuilder row : rows) ret.append(row);
            return ret.toString();
        }
    }
}
