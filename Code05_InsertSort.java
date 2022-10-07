import Utilities.Utils;

/**
 * 插入排序
 * 原理：给定一个数组，0 ~ 0上已经有序，
 * 0 ~ 1：如果arr[1] < arr[0]交换
 * 0 ~ 2：如果arr[2]< arr[1]交换，如果不小，进入下一个循环
 * 0 ~ n-1：同上
 */

public class Code05_InsertSort {
    public static void main(String[] args) {
        int testTimes = 1000;
        for (int i = 0; i < testTimes; i++) {
            int[] arr01 = Utils.randomArray(10, 100);
            insertSort(arr01);
            if (!Utils.isSorted(arr01)) {
                System.out.println("插入排序算法出错了");
            }
        }
    }

    private static void insertSort(int[] arr) {
        // 先确定边界情况
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int newValueIndex = i;
            while (newValueIndex - 1 >= 0 && arr[newValueIndex - 1] > arr[newValueIndex]) {
                Utils.swap(arr, newValueIndex - 1, newValueIndex);
                newValueIndex--;
            }
        }
    }
}
