package lin.changcheng.leetcode;

/**
 * 计算一个输入数字的开方
 *
 * @author greatwall
 */
public class Sqrt {
	public int mySqrt(int x) {
		if (x <= 1)
			return x;
		int l = 1, h = x;
		while (l <= h) {
			int mid = l + (h - l) / 2;
			int sqrt = x / mid;
			if (sqrt == mid)
				return mid;
			else if (sqrt < mid)
				h = mid - 1;
			else
				l = mid + 1;
		}
		return h;

	}

	public static void main(String[] args) {
		Sqrt sqrt = new Sqrt();
		System.out.println(sqrt.mySqrt(10));
		System.out.println(sqrt.mySqrt(9));
		System.out.println(sqrt.mySqrt(15));
		System.out.println(sqrt.mySqrt(17));
	}
}
