package cn.com.pcalpha;

public class Q377_ReverseString {
    public static void main(String[] args) {
        char[] input = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString(input);

    }


    public static void reverseString(char[] s) {
        int length = s.length;
        for (int i = 0; i < length / 2; i++) {
            char temp = s[i];
            s[i] = s[length-i-1];
            s[length-i-1] = temp;
        }

        System.out.println(s);
    }
}
