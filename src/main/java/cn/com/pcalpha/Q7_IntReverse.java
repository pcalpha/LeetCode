package cn.com.pcalpha;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 *
 *
 */
public class Q7_IntReverse {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reverse(321);

    }

    static class Solution1 {
        public int reverse(int x) {
            long n = 0;
            while(x != 0) {
                n = n*10 + x%10;
                x = x/10;
            }
            return (int)n==n? (int)n:0;
        }
    }

    static class Solution {
        public int reverse(int x) {
            int sign = x>=0?1:-1;
            String str = Math.abs(x)+"";
            char[] charArr = str.toCharArray();
            int len = charArr.length;
            for(int i=0;i<len/2;i++){
                char temp = charArr[i];
                charArr[i] = charArr[len-1-i];
                charArr[len-1-i] = temp;
            }

            int result = 0;
            try{
                result = sign*Integer.valueOf(new String(charArr));
            } catch (Exception e){

            }

            return result;
        }
    }
}
