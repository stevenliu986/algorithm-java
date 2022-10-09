import Utilities.Utils;

import java.util.Arrays;

public class Code07_Find {
    public static void main(String[] args) {
        int[] arr01 = Utils.randomArray(10, 100);
        Code05_InsertSort.insertSort(arr01);
        int ans = findMostRightIndex(arr01, 20);
        System.out.println(Arrays.toString(arr01));
        System.out.println(ans);

        int ans01 = findMostLeftIndex(arr01, 21);

        System.out.println(ans01);
    }

    // 在给定的有序数组中查找>=给定数的最左的位置的下标
    private static int findMostLeftIndex(int[] arr, int value) {
        if (arr == null || arr.length == 0) return -1;
        int left = 0;
        int right = arr.length - 1;
        int mostLeftIndex = -1;
        while (left <= right) {
            int midIndex = (left + right) / 2;
            if (arr[midIndex] >= value) {
                mostLeftIndex = midIndex;
                right = midIndex - 1;
            } else left = midIndex + 1;
        }
        return mostLeftIndex;
    }

    // 在给定的有序数组中查找<=给定数的最右的位置的下标
    private static int findMostRightIndex(int[] arr, int value) {
        if (arr == null || arr.length == 0) return -1;
        int left = 0;
        int right = arr.length - 1;
        int mostRightIndex = -1;
        while (left <= right) {
            int midIndex = (left + right) / 2;
            if (arr[midIndex] <= value) {
                mostRightIndex = midIndex;
                left = midIndex + 1;
            } else right = midIndex - 1;
        }
        return mostRightIndex;
    }

    // 给定整体无序且相邻的数不相等的一个数组，查找局部最小数并返回该数的下标
    private static int oneMinIndex(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        if (arr.length == 1) return 0;
        int len = arr.length;
        if (arr[0] < arr[1]) return 0;
        if (arr[len - 1] < arr[len - 2]) return len - 1;
        int left = 0;
        int right = len - 1;
        while (left < right - 1) {
            int midIndex = (left + right) / 2;
            if (arr[midIndex] < arr[midIndex - 1] && arr[midIndex] < arr[midIndex + 1]) {
                return midIndex;
            } else {
                if (arr[midIndex] > arr[midIndex - 1]) {
                    right = midIndex - 1;
                } else left = midIndex + 1;
            }
        }
        return arr[left] < arr[right] ? left : right;
    }

    // 生成整体无序且相邻的数不相等的数组
    private static int[] randomArray(int maxLength, int maxValue) {
        int len = (int) (Math.random() * maxLength);
        int[] arr = new int[len];
        if (len > 0) {
            arr[0] = (int) (Math.random() * maxValue);
            for (int i = 1; i < len; i++) {
                do {
                    arr[i] = (int) (Math.random() * maxValue);
                } while (arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }

    // 验证是否为局部最小值
    private static boolean check(int[] arr, int minIndex) {
        if (arr.length == 0) {
            return minIndex == -1;
        }
        int left = minIndex - 1;
        int right = minIndex + 1;
        boolean leftBigger = left < 0 || arr[left] > arr[minIndex];
        boolean rightBigger = right >= arr.length || arr[right] > arr[minIndex];
        return leftBigger && rightBigger;
    }
}
