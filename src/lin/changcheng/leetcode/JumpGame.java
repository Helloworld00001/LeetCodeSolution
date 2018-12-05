package lin.changcheng.leetcode;

/**
 * 跳房子游戏
 *
 * @author greatwall
 */
public class JumpGame {

//	public int jump(int[] nums) {
//		int reach = 0;//全局最远可达位置
//		int last = 0;//上一步最远能到达位置
//		int step = 0;//i需要超过上一步最远位置时加1
//		for (int i = 0; i <= reach && i < nums.length; i++) {
//			if (i > last) {
//				step++;
//				last = reach;
//			}
//			reach = max(reach, nums[i] + i);
//		}
//		return reach >= (nums.length - 1) ? step : 0;//超过也算是到了终点
//
//	}
//
//	private int max(int a, int b) {
//		return a >= b ? a : b;
//	}

	public int jump(int[] A) {
		if (A == null || A.length == 0) {
			return -1;
		}
		int start = 0, end = 0, jumps = 0;
		while (end < A.length - 1) {
			int farthest = end;
			System.out.println("Jump=" + jumps);
			System.out.println("Current farthest = " + farthest + ", start=" + start + ", end=" + end);
			for (int i = start; i <= end; i++) {
				if (A[i] + i > farthest) {
					farthest = A[i] + i;
					System.out.println("farthest=" + farthest);

				}
			}
			start = end + 1;
			end = farthest;
			jumps++;

		}
		return jumps;
	}

	public static void main(String[] args) {
		int[] arr =  {2, 3, 4, 1, 3, 2, 1, 1};
		JumpGame game = new JumpGame();

		System.out.println(game.jump(arr));
	}

}


