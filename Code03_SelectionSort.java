import Utilities.Utils;

/**
 * 选择排序
 * 原理：先假设数组的第一个元素是最小值，取它的下标，用这个数与数组中的其他数进行比较，
 * 如果找到比它小的数，就将下标替换，等一轮循环完毕，如果找到比假设的数还小的数，就将该数与假设的数交换。
 * 然后再进行下一轮的查找，直到将整个数组查找完毕。
 */
public class Code03_SelectionSort {
    public static void main(String[] args) {
        int testTimes = 1000;
        for (int i = 0; i < testTimes; i++) {
            int[] arr01 = Utils.randomArray(10, 100);
            selectionSort(arr01);
            if (!Utils.isSorted(arr01)) {
                System.out.println("选择排序算法出错了");
            }
        }
    }

    private static void selectionSort(int[] arr) {
        // 先确定边界情况，如果数组为空或数组长度小于2，则毋须进行排序
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            Utils.swap(arr, i, minValueIndex);
        }
    }

}
