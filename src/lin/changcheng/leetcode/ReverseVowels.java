package lin.changcheng.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 反转元音字符串
 * @see <a href="https://leetcode.com/problems/reverse-vowels-of-a-string/description/">345. Reverse Vowels of a String</a>
 *
 * @author greatwall
 */
public class ReverseVowels {

	private HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

	public String reverseVowels(String s) {
		int i = 0, j = s.length() - 1;
		char[] result = new char[s.length()];
		while (i <= j) {
			char ci = s.charAt(i);
			char cj = s.charAt(j);
			if (!vowels.contains(ci))
				result[i++] = ci;
			else if (!vowels.contains(cj))
				result[j--] = cj;
			else {
				result[i++] = cj;
				result[j--] = ci;
			}
		}
		return new String(result);
	}
	public static void main(String[] args) {

		String s = "hello";
		String s2 = "leetcode";

		ReverseVowels reverseVowels = new ReverseVowels();
		System.out.println(reverseVowels.reverseVowels(s));
		System.out.println(reverseVowels.reverseVowels(s2));

	}
}
