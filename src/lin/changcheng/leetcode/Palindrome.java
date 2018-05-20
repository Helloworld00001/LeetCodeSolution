package lin.changcheng.leetcode;

/**
 * 判断回文算法
 *
 * @author greatwall
 */
public class Palindrome {

	public boolean validPalindrome(String s) {
		int i = -1, j = s.length();
		while (++i < --j)
			if (s.charAt(i) != s.charAt(j))
				return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);

		return true;
	}

	private boolean isPalindrome(String s, int i, int j) {
		System.out.println("当前s=" + s);
		while (i < j)
			if (s.charAt(i++) != s.charAt(j--))
				return false;

		return true;
	}

	public static void main(String[] args) {
		Palindrome palindrome = new Palindrome();
		System.out.println(palindrome.validPalindrome("dabbacb"));

		System.out.println("----------------------");
		System.out.println(palindrome.validPalindrome("cabbacb"));

		System.out.println("----------------------");
		System.out.println(palindrome.validPalindrome("abba"));
	}
}
