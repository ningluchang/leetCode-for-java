import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * <p>
 * 你可以按任意顺序返回答案。
 */
class Solution {
    // 原始的双重for循环
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // 减少部分计算
    public int[] twoSumInterpolation(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (complement == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // 哈希map方式
    public int[] twoSumMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4, 15};
        int target = 18;
        Solution solution = new Solution();
        int[] result = solution.twoSumMap(nums, target);
        System.out.println(Arrays.toString(result));
    }
}