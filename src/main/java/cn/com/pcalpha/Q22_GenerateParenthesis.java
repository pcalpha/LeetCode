package cn.com.pcalpha;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q22_GenerateParenthesis {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));
    }

    static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();

            generate(n,0,0,0,new char[2*n], result);
            return result;

        }

        public void generate(int n, int depth, int lp, int rp, char[] chars, List<String> result) {
            if (depth == 2 * n) {
                result.add(new String(chars));
            } else {
                if (lp < n) {
                    chars[depth] = '(';
                    generate(n, depth + 1, lp + 1, rp, chars, result);
                }
                if (rp < lp) {
                    chars[depth] = ')';
                    generate(n, depth + 1, lp, rp + 1, chars, result);
                }
            }
        }
    }
}
