package cn.com.pcalpha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 给定一个包含n 个整数的数组nums和一个目标值target，判断nums中是否存在四个元素 a，b，c和 d，使得a + b + c + d的值与target相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q18_FourSum {
    public static void main(String[] args) {
        Solution solution = new Solution();

        //[1,-2,-5,-4,-3,3,3,5]
        //-11
        int[] nums = new int[]{1,-2,-5,-4,-3,3,3,5};

        System.out.println(solution.fourSum(nums, -11));
    }


    static class Solution {
        private int target;

        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            this.target = target;
            List<List<Integer>> result = new ArrayList<>();
            visit(nums, 0, 0, new ArrayList<Integer>(), result);
            return result;
        }

        public void visit(int[] nums, int left, int sum, List<Integer> path, List<List<Integer>> result) {
            if (path.size() == 4) {
                if (path.get(0) + path.get(1) + path.get(2) + path.get(3) == target) {
                    result.add(new ArrayList<>(path));
                }
            } else {
                for (int i = left; i < nums.length; i++) {
                    if (nums.length - i < (4 - path.size())) {
                        return;
                    }
                    if (i > left && nums[i] == nums[i - 1]) {
                        continue;
                    }
                    if (sum + (4-path.size())*nums[i] > target) {
                        return;
                    }
                    if (sum + (4-path.size())*nums[nums.length - 1] < target) {
                        return;
                    }

                    path.add(nums[i]);
                    sum = sum + nums[i];
                    visit(nums, i + 1, sum, path, result);
                    int lastrmv = path.remove(path.size() - 1);
                    sum -= lastrmv;
                }
            }
        }
    }
}
