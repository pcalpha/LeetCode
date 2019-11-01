package cn.com.pcalpha;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question3_NoLoopChar {

  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
    System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    System.out.println(solution.lengthOfLongestSubstring("c"));
    System.out.println(solution.lengthOfLongestSubstring("au"));
    System.out.println(solution.lengthOfLongestSubstring(""));
    System.out.println(solution.lengthOfLongestSubstring(" "));
  }


  static class Solution {
    public int lengthOfLongestSubstring(String s) {
      String str = "";
      String str2 = "";


      int count = 0;
      //循环表示游标位置
      for (int i = 0; i < s.length(); i++) {
        //内存循环取的字符个数
        for (int j = 1; j <= s.length() - i; j++) {
          str = s.substring(i, i + j);

          if (i + j + 1 <= s.length()) {
            str2 = s.substring(i + j, i + j + 1);
          } else {
            str2 = "";
          }

          //System.out.println(str+"::"+str2);
          int len = str.length();
          if (len >= count) {
            count = len;
          }
          if (str.contains(str2)) {
            break;
          }
        }
        //System.out.println("===========");
      }
      return count;
    }
  }

}


