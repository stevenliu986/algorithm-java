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
}
