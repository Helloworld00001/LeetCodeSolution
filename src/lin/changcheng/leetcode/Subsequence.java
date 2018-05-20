package lin.changcheng.leetcode;

/**
 * 两个输入字符串，前者是否为后者的子串
 * @see <a href="https://leetcode.com/problems/is-subsequence/description/">392. Is Subsequence</a>
 *
 * @author greatwall
 */
public class Subsequence {

	public boolean isSubsequence(String s, String t) {
		int index = -1;
		for (char c : s.toCharArray()) {
			index = t.indexOf(c, index + 1);
			if (index == -1)
				return false;
		}
		return true;

	}

	public static void main(String[] args) {
		String s = "abc", t = "hbgdcda";
		Subsequence subsequence = new Subsequence();
		System.out.println(subsequence.isSubsequence(s, t));

	}
}
