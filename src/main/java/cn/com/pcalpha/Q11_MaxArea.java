package cn.com.pcalpha;


/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 示例：
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 */
public class Q11_MaxArea {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution.maxArea(input));

    }

    static class Solution {
        public int maxArea(int[] height) {
            int len = height.length;

            int max = 0;
            for (int i = 0; i < len - 1; i++) {
                for (int j = i + 1; j < len; j++) {
                    int s = (j - i) * Math.min(height[j], height[i]);
                    max = s > max ? s : max;
                }
            }

            return max;
        }
    }


    /**
     * 双指针代表的是 可以作为容器边界的所有位置的范围。在一开始，双指针指向数组的左右边界，表示 数组中所有的位置都可以作为容器的边界，因为我们还没有进行过任何尝试。在这之后，我们每次将 对应的数字较小的那个指针 往 另一个指针 的方向移动一个位置，就表示我们认为 这个指针不可能再作为容器的边界了。
     * 为什么对应的数字较小的那个指针不可能再作为容器的边界了？
     * 在上面的分析部分，我们对这个问题有了一点初步的想法。这里我们定量地进行证明。
     * 考虑第一步，假设当前左指针和右指针指向的数分别为 xx 和 yy，不失一般性，我们假设 x≤y。同时，两个指针之间的距离为 t。那么，它们组成的容器的容量为：
     * min(x, y) * t = x * t
     * 我们可以断定，如果我们保持左指针的位置不变，那么无论右指针在哪里，这个容器的容量都不会超过 x * t了。注意这里右指针只能向左移动，因为 我们考虑的是第一步，也就是 指针还指向数组的左右边界的时候。
     * 我们任意向左移动右指针，指向的数为 y1，两个指针之间的距离为 t1，那么显然有 t1 < t，并且 min(x, y1) <=min(x, y)，
     * 如果 y1 <= y，那么 min(x, y1) <=min(x, y)
     * 如果 y1 > y，那么 min(x, y1) = x = min(x, y)
     * 因此有：min(x, yt) * t1 < min(x, y) * t
     * 即无论我们怎么移动右指针，得到的容器的容量都小于移动前容器的容量。也就是说，这个左指针对应的数不会作为容器的边界了，那么我们就可以丢弃这个位置，将左指针向右移动一个位置，此时新的左指针于原先的右指针之间的左右位置，才可能会作为容器的边界。
     * 这样以来，我们将问题的规模减小了 1，被我们丢弃的那个位置就相当于消失了。此时的左右指针，就指向了一个新的、规模减少了的问题的数组的左右边界，因此，我们可以继续像之前 考虑第一步 那样考虑这个问题：
     * 求出当前双指针对应的容器的容量；
     * 对应数字较小的那个指针以后不可能作为容器的边界了，将其丢弃，并移动对应的指针。
     * 最后的答案是什么？
     * 答案就是我们每次以双指针为左右边界（也就是「数组」的左右边界）计算出的容量中的最大值。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/container-with-most-water/solution/sheng-zui-duo-shui-de-rong-qi-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    static class Solution1 {
        public int maxArea(int[] height) {
            int l = 0, r = height.length - 1;
            int ans = 0;
            while (l < r) {
                int area = Math.min(height[l], height[r]) * (r - l);
                ans = Math.max(ans, area);
                if (height[l] <= height[r]) {
                    ++l;
                }
                else {
                    --r;
                }
            }
            return ans;
        }
    }
}
