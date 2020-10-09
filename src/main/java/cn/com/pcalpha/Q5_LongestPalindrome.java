package cn.com.pcalpha;

public class Q5_LongestPalindrome {
    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        String str = "abba";

        Solution solution = new Solution();

        //System.out.println(solution.longestPalindrome(str));

        System.out.println(solution.longestPalindrome(str));
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);


        Solution2 solution1 = new Solution2();
        System.out.println(solution1.longestPalindrome(str));
    }


    //暴力破解
    static class Solution {
        public String longestPalindrome(String str) {
            int len = str.length();
            if (len < 2) {
                return str;
            }

            char[] chars = str.toCharArray();//加速计算，降低寻址时间

            int start = 0;
            int maxLen = 1;
            for (int i = 0; i < len - 1; i++) {
                for (int j = i + 1; j < len; j++) {
                    boolean flag = isPalindrome(chars, i, j);
                    if (flag && (j - i + 1) > maxLen) {
                        maxLen = j - i + 1;
                        start = i;
                    }
                }
            }
            return str.substring(start, start + maxLen);
        }

        public boolean isPalindrome(char[] chars, int left, int right) {
            while (left < right) {
                char c1 = chars[left];
                char c2 = chars[right];
                if (c1 != c2) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }

        public boolean isPalindrome(String s) {
            int len = s.length();
            for (int i = 0; i < len / 2; i++) {
                char c1 = s.charAt(i);
                char c2 = s.charAt(len - 1 - i);
                if (c1 != c2) {
                    return false;
                }
            }
            return true;
        }
    }


    /**
     * 动态规划
     */
    static class Solution1 {
        public String longestPalindrome(String s) {
            int len = s.length();
            boolean[][] dp = new boolean[len][len];
            int maxLen = 1;
            int begin = 0;
            //对角线确定结果
            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
            }
            for (int j = 1; j < len; j++) {
                for (int i = 0; i < j; i++) {
                    if (s.charAt(i) != s.charAt(j)) {
                        dp[i][j] = false;
                    } else {
                        if (j - i < 3) {//j-i+1<2
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    }

                    if (dp[i][j] && j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        begin = i;
                    }
                }
            }
            return s.substring(begin, begin + maxLen);
        }
    }


    /**
     *      babab
     *      b   a   b   s   b
     *      0   1   2   3   4
     *
     *      0   1   2   3   4
     *  0   T   F   T   F   T
     *  1       T   F   T   F
     *  2           T   F   T
     *  3               T   F
     *  4                   T
     */
    static class Solution2 {
        public String longestPalindrome(String s) {
            int n = s.length();
            boolean[][] dp = new boolean[n][n];
            String ans = "";
            for (int x = 0; x < n; ++x) {//x代表子串长度
                for (int i = 0; i + x < n; ++i) {
                    int j = i + x;
                    if (x == 0) {//此时i==j,代表子串长度1
                        dp[i][j] = true;
                    } else if (x == 1) {//判断自身就可以了,代表子串长度2
                        dp[i][j] = (s.charAt(i) == s.charAt(j));
                    } else {//根据前面的匹配结果
                        dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                    }
                    if (dp[i][j] && x + 1 > ans.length()) {
                        ans = s.substring(i, j + 1);
                    }
                }
            }
            return ans;
        }
    }

}
