package Utilities;

public class Utils {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    // 生成一个长度和最大值都是随机的数组
    public static int[] randomArray(int maxLength, int maxValue) {
        int length = (int) (Math.random() * maxLength);
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = (int) (Math.random() * maxValue);
        }
        return array;
    }

    // 验证数组是否有序（从小到大）
    public static boolean isSorted(int[] arr) {
        if (arr == null || arr.length < 2) {
            return true;
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max > arr[i]) {
                return false;
            }
            max = Math.max(max, arr[i]);
        }
        return true;
    }

    // 在有序数组中查找是否存在指定的数
    public static boolean arrHasNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int midIndex = (left + right) / 2;
            if (arr[midIndex] == num) {
                return true;
            } else if (arr[midIndex] < num) {
                left = midIndex + 1;
            } else {
                right = midIndex - 1;
            }
        }
        return false;
    }
}
