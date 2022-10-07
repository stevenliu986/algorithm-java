import java.util.Arrays;

public class Code04_BubbleSort {
    public static void main(String[] args) {
        int[] arr01 = {2, 5, 90, 4, -1, 45, 34, 23};
        bubbleSort(arr01);
        System.out.println(Arrays.toString(arr01));
    }

    private static void bubbleSort(int[] arr) {
        // 先确定边界情况
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
