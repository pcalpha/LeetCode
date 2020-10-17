package cn.com.pcalpha;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Q16_ThreeSumClosest {


    static class Solution {

        public int threeSumClosest(int[] nums, int target) {
            List<List<Integer>> list = new ArrayList<>();

            Arrays.sort(nums);
            int min = Integer.MAX_VALUE;
            int minSum = 0;
            for (int i = 0; i < nums.length - 2; i++) {
                int left = i + 1;
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    //记录最小值，其他逻辑跟三数之和为0的逻辑一致
                    if (Math.abs(sum - target) <= min) {
                        min = Math.abs(sum - target);
                        minSum = sum;
                    }
                    if (sum - target > 0) {
                        right--;
                    } else if (sum - target < 0) {
                        left++;
                    } else if (sum - target == 0) {
                        list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        left++;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                            continue;
                        }
                    }
                }
            }
            return minSum;
        }
    }
}
