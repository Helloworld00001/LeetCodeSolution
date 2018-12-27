package lin.changcheng.algorithm.search;

/**
 * @author greatwall
 */
public class ArraySearch {
	public static void main(String[] args) {
		ArraySearch arraySearch = new ArraySearch();
		int[] nums = new int[] {4, 2 , 4, 3, 0};
		System.out.println(arraySearch.findDuplicateNum(nums));
	}

	public int findDuplicateNum(int[] nums) {
		if (nums == null)
			return -1;
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] != i) {
				if (nums[i] == nums[nums[i]]) {
					return nums[i];
				}
				swap(nums, i, nums[i]);
			}
		}
		return -1;
	}

	private void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}
}
