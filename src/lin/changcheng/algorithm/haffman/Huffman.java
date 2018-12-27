package lin.changcheng.algorithm.haffman;

import java.util.*;

/**
 * @author greatwall
 */
public class Huffman {
	private Map<Character, char[]> charEncodingDic;

	private class Node implements Comparable<Node> {
		char ch;
		int freq;
		boolean isLeaf;
		Node left, right;

		public Node(char ch, int freq) {
			this.ch = ch;
			this.freq = freq;

			isLeaf = true;
		}

		public Node(Node left, Node right, int freq) {
			this.left = left;
			this.right = right;
			this.freq = freq;

			isLeaf = false;
		}

		@Override
		public int compareTo(Node o) {
			return this.freq - o.freq;
		}
	}

	public static void main(String[] args) {
		Huffman huffman = new Huffman();
		String input = "我的小白";
		System.out.println(input);

		StringBuilder sb = new StringBuilder();
		char[] chars = input.toCharArray();
		for (char ch : chars) {
			int n = (int) ch;
			System.out.println("n=" + n + ",ch="+ ch);
			sb.append(Integer.toBinaryString(n));
		}
		System.out.println("没有压缩过的二进制=" + sb);
		String bits = huffman.encode(input);
		System.out.println(bits);
		System.out.println(huffman.decode(bits));
	}

	/**
	 * 对二进制字符，根据哈夫曼字符编码字典进行解码
	 *
	 * @param bits
	 * @return
	 */
	public String decode(String bits) {
		if(this.charEncodingDic == null) {
			throw new IllegalStateException("No encoding dictionary, can not decode this input bits!");
		}

		Map<String, Character> encodingCharMap = new HashMap<>();
		for (Map.Entry<Character, char[]> entry : this.charEncodingDic.entrySet()) {
			encodingCharMap.put(String.valueOf(entry.getValue()), entry.getKey());
		}

		StringBuilder output = new StringBuilder();
		char[] charOfBits = bits.toCharArray();

		int i = 0;
		while(i < charOfBits.length) {
			StringBuilder sb = new StringBuilder();
			for(int j = i;j < charOfBits.length;j++ ) {
				sb.append(charOfBits[j]);
				Character ch = encodingCharMap.get(sb.toString());

				if(ch != null) {
					output.append(ch);
					i = j + 1;
					break;
				}
			}
		}

		return output.toString();
	}



	/**
	 * 对输入的字符串用哈夫曼编码后输出对应的二进制编码
	 *
	 * @param input
	 * @return
	 */
	public String encode(String input) {
		this.charEncodingDic = encode(parse(input));

		StringBuilder sb = new StringBuilder();
		for(char ch : input.toCharArray()) {
			sb.append(this.charEncodingDic.get(ch));
		}
		return sb.toString();
	}

	private Map<Character, Integer> parse(String input) {
		Map<Character, Integer> characterFrequencyMap = new HashMap<>();
		for(char c : input.toCharArray()) {
			characterFrequencyMap.compute(c, (key, value) -> {
				if(value == null) {
					value = 0;
				}
				int currentValue = value;
				return ++currentValue;

			});
		}
		return characterFrequencyMap;
	}

	/**
	 * 输入各个字符的权重键值对，输出经过哈夫曼编码后的各个字符编码字典
	 *
	 * @param frequencyForChar
	 * @return
	 */
	private Map<Character, char[]> encode(Map<Character, Integer> frequencyForChar) {
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
		for (Map.Entry<Character, Integer> entry : frequencyForChar.entrySet()) {
			priorityQueue.add(new Node(entry.getKey(), entry.getValue()));
		}

		while(priorityQueue.size() != 1) {
			Node node1 = priorityQueue.poll();
			Node node2 = priorityQueue.poll();

			Node parentNode = new Node(node1, node2, node1.freq + node2.freq);
			priorityQueue.add(parentNode);
		}

		return encode(priorityQueue.poll());
	}

	private Map<Character, char[]> encode(Node root) {
		Map<Character, char[]> encodingCharDic = new HashMap<>();
		encode(root, "", encodingCharDic);
		return encodingCharDic;
	}

	private void encode(Node node, String encoding, Map<Character, char[]> encodingCharDic) {
		if(node.isLeaf) {
			encodingCharDic.put(node.ch, encoding.toCharArray());
			return;
		}
		encode(node.left, encoding + '0', encodingCharDic);
		encode(node.right, encoding + '1', encodingCharDic);
	}
}
