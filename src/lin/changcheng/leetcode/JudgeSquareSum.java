package lin.changcheng.leetcode;

/**
 * 判断输入是否可以成为两个数的平方和
 *
 * @author greatwall
 */
public class JudgeSquareSum {

	public boolean judgeSquareSum(int c) {
		int max = (int) Math.sqrt(c);

		int min = 0;

		while(min <= max) {
			int cal = min * min + max * max;
			if(cal == c) {
				return true;
			}
			if(cal > c ) {
				max--;
			 }
			 min++;
 		}

 		return false;
	}

	public static void main(String[] args) {
		JudgeSquareSum judgeSquareSum = new JudgeSquareSum();
		System.out.println(judgeSquareSum.judgeSquareSum(8));
		System.out.println(judgeSquareSum.judgeSquareSum(10));
		System.out.println(judgeSquareSum.judgeSquareSum(11));

	}
}
