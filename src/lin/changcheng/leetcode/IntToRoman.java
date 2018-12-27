package lin.changcheng.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 输入正整数输出罗马数字
 * <p>
 * @see <a href="https://leetcode.com/problems/integer-to-roman/description/">12. Integer to Roman</a>
 *
 * @author greatwall
 */
public class IntToRoman {
	private static Map<Integer, String> map = new HashMap<>();

	static {
		map.put(1000, "M");
		map.put(500, "D");
		map.put(100, "C");
		map.put(50, "L");
		map.put(10, "X");
		map.put(5, "V");
		map.put(1, "I");
	}

	public String intToRoman(int num) {
		int digit = 1000;

		StringBuilder sb = new StringBuilder();

		while(digit >= 1) {
			int n = num / digit;
			sb.append(parseToRoman(n, digit));

			num = num % digit;
			digit = digit / 10;
		}
		return sb.toString();
	}

	private String parseToRoman(int n, int currentDigit) {
		if(currentDigit == 1000) {
			return IntStream.range(0, n).mapToObj(number -> map.get(currentDigit)).collect(Collectors.joining());
		}

		if(n == 0) {
			return "";
		} else if(n < 4) {
			return IntStream.range(0, n).mapToObj(number -> map.get(currentDigit)).collect(Collectors.joining());
		} else if(n == 4) {
			return map.get(currentDigit) + map.get(currentDigit * 5);
		} else if(n == 5) {
			return map.get(currentDigit * 5);
		} else if(n == 9) {
			return map.get(currentDigit) + map.get(currentDigit * 10);
		} else {
			return map.get(currentDigit * 5) + IntStream.range(0, n - 5).mapToObj(number -> map.get(currentDigit)).collect(Collectors.joining());
		}
	}

	public static void main(String[] args) {
		IntToRoman intToRoman = new IntToRoman();
		System.out.println(intToRoman.intToRoman(3));

		System.out.println(intToRoman.intToRoman(4));

		System.out.println(intToRoman.intToRoman(9));

		System.out.println(intToRoman.intToRoman(58));

		System.out.println(intToRoman.intToRoman(1994));

		System.out.println(intToRoman.intToRoman(3999));
	}

}
