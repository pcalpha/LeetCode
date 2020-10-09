package cn.com.pcalpha;

import java.util.HashMap;
import java.util.Map;

public class Q3_LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring2(s));
    }


    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int max = 1;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j + i < s.length(); j = j + 1) {
                String temp = s.substring(i - 1, j + i);
                char c = s.charAt(j + i);

                if (temp.indexOf(String.valueOf(c)) < 0) {
                    if (max < temp.length() + 1) {
                        max = temp.length() + 1;
                    }
                } else {
                    break;
                }
            }
        }
        return max;
    }


    //滑动窗口，有视频
    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length(), max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);//单个字母
            if (map.containsKey(alpha)) {//通过key判断是否重复
                start = Math.max(map.get(alpha), start);//更新起始值
            }
            max = Math.max(max, end + 1 - start);
            map.put(s.charAt(end), end + 1);//记录当前字母最新位置
        }
        return max;
    }
}
