package lin.changcheng.leetcode;

/**
 * 从字符数组中找出比目标字符大的最小字符
 *
 * @author greatwall
 */
public class Letter {

	/**
	 * letters 是一个从小到大排序过的字符数组
	 *
	 * @param letters
	 * @param target
	 * @return
	 */
	public char nextGreatestLetter(char[] letters, char target) {
		int l = 0;
		int h = letters.length - 1;

		while (l <= h) {
			int middle = l + (h - l) / 2;
			if(letters[middle] == target) {
				return letters[middle + 1];
			} else if(letters[middle] < target) {
				l = middle + 1;
			} else {
				h = middle - 1;
			}
		}

		return l < letters.length ? letters[l] : letters[0];
	}

	public static void main(String[] args) {
	Letter letter = new Letter();
	char[] letters = new char[]{'a', 'c', 'f', 'h'};
	char target = 'f';
	System.out.println(letter.nextGreatestLetter(letters, target));

	}
}
