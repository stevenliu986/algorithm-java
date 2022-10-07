import Utilities.Utils;

/**
 * 冒泡排序
 * 原理：将前一位的数与后面的数进行比较，如果前面的数比后面的数大，两两交换，直到将
 * 最大的数放到最后，然后数组的长度减一，以此类推
 */

public class Code04_BubbleSort {
    public static void main(String[] args) {
        int testTimes = 1000;
        for (int i = 0; i < testTimes; i++) {
            int[] arr01 = Utils.randomArray(10, 100);
            bubbleSort(arr01);
            if (!Utils.isSorted(arr01)) {
                System.out.println("冒泡排序算法出错了");
            }
        }
    }

    private static void bubbleSort(int[] arr) {
        // 先确定边界情况
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (arr[j - 1] > arr[j]) {
                    Utils.swap(arr, j - 1, j);
                }
            }
        }
    }

//    private static void swap(int[] arr, int i, int j) {
//        int temp = arr[j];
//        arr[j] = arr[i];
//        arr[i] = temp;
//    }
}
