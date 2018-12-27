package lin.changcheng.algorithm.sort;

/**
 * @author greatwall
 */
public class MergeSort<T extends Comparable<T>> extends Sort<T> {
	@Override
	public void sort(T[] nums) {
		Comparable[] temp = new Comparable[nums.length];

		sort(nums, 0, nums.length - 1, (T[]) temp);
	}

	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		Integer[] n = new Integer[] {
				2, 5, 1, 50, 12, 0, 30
		};
		mergeSort.sort(n);
		for (int i = 0;i < n.length -1;i++) {
			System.out.println(n[i]);

		}
	}

	protected void sort(T[] nums, int left, int right, T[] temp) {
		if(left < right) {
			int middle = (left + right) / 2;
			sort(nums, left, middle, temp);
			sort(nums, middle + 1, right, temp);
			merge(nums, left, middle, right, temp);
		}

	}

	private void merge(T[] arr, int left, int middle, int right, T[] temp) {
		int i = left;
		int j = middle + 1;
		int t = 0;

		while(i <= middle && j <= right) {
			if(arr[i].compareTo(arr[j]) <= 0) {
				temp[t++] = arr[i++];
			} else {
				temp[t++] = arr[j++];
			}
		}

		while(i <= middle) {
			temp[t++] = arr[i++];
		}

		while(j <= right) {
			temp[t++] = arr[j++];
		}

		t = 0;
		while (left <= right) {
			arr[left++] = temp[t++];
		}

	}
}
