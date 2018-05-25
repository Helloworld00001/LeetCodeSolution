package lin.changcheng.leetcode;

/**
 * 有序数组中找出没有重复出现的数
 *
 * @author greatwall
 */
public class SingleElement {

	public int singleNonDuplicate(int[] nums) {
		int l = 0, h = nums.length - 1;
		while(l < h) {
			int m = l + (h - l) / 2;
			if((m & 1) == 1) {
				m--;
			}

			if(nums[m] == nums[m + 1]) {
				l = m + 2;
			} else {
				h = m;
			}

		}

		return nums[l];

	}

	public static void main(String[] args) {
		SingleElement singleElement = new SingleElement();
		System.out.println(singleElement.singleNonDuplicate(new int[] {1, 1, 5, 5, 7, 7, 9, 9, 10}));
	}
}
