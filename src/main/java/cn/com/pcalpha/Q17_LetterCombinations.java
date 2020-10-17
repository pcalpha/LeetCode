package cn.com.pcalpha;


import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class Q17_LetterCombinations {


    static class Solution {

        static char[] _1 = new char[]{};
        static char[] _2 = new char[]{'a', 'b', 'c'};
        static char[] _3 = new char[]{'d', 'e', 'f'};
        static char[] _4 = new char[]{'g', 'h', 'i'};
        static char[] _5 = new char[]{'j', 'k', 'l'};
        static char[] _6 = new char[]{'m', 'n', 'o'};
        static char[] _7 = new char[]{'p', 'q', 'r', 's'};
        static char[] _8 = new char[]{'t', 'u', 'v'};
        static char[] _9 = new char[]{'w', 'x', 'y', 'z'};
        static char[] _0 = new char[]{};


        public List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<>();
            if ("".equals(digits)) {
                return result;
            }


            char[] chars = digits.toCharArray();
            int len = chars.length;

            visit1(digits, 0, result, new StringBuilder());

            return result;
        }


        public void visit1(String digits, int index, List<String> result, StringBuilder sb) {
            if (index == digits.length()) {
                result.add(sb.toString());
            } else {
                char c = digits.charAt(index);
                char[] letter = getValue(c);
                int letterLen = letter.length;
                for (int i = 0; i < letterLen; i++) {
                    sb.append(letter[i]);
                    visit1(digits, index + 1, result, sb);
                    sb.deleteCharAt(index);
                }
            }
        }


        public char[] getValue(char s) {
            switch (s) {
                case '1':
                    return _1;
                case '2':
                    return _2;
                case '3':
                    return _3;
                case '4':
                    return _4;
                case '5':
                    return _5;
                case '6':
                    return _6;
                case '7':
                    return _7;
                case '8':
                    return _8;
                case '9':
                    return _9;
                case '0':
                    return _0;
                default:
                    return new char[]{};
            }
        }
    }
}
