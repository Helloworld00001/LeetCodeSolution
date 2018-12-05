package lin.changcheng.leetcode;

/**
 * 股票最佳化
 *
 * @author greatwall
 */
public class StockMaxProfit {

	//[7,1,5,3,6,4]
	//[7,6,4,3,1]
	public int maxProfit(int[] prices) {
		int res = 0;
		if (prices.length <= 1) return res;
		int curmin = prices[0];
		for (int i = 0; i < prices.length; i++) {
			if (curmin > prices[i]) curmin = prices[i];
			if (res < (prices[i] - curmin)) res = (prices[i] - curmin);
		}//只要大于前者就是收益
		return res;
	}


	//2 3 1 5 5 9 2 那么最大的利益就是2-3和1-9段相加为9。故只需找出局部递增序列。
	public int maxProfit2_2(int[] prices) {
		int profit = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			int diff = prices[i+1] - prices[i];
			if (diff > 0) {
				profit += diff;
			}
		}
		return profit;
	}


	int maxProfit2(int[] prices) {
		int res = 0;
		if (prices.length <= 1) return res;
		for (int i = 0; i < prices.length; ) {
			int j = i;
			while (j + 1 < prices.length && prices[j + 1] > prices[j])
				j++;
			if (j == i) {
				i++;
			}//一开始就不增加
			else {
				res += prices[j] - prices[i];
				i = j + 1;
			}//增加若干
		}
		return res;
	}
}
