public class Code07_Find {
    public static void main(String[] args) {

    }

    // 在给定的有序数组中查找>=给定数的最左的位置的下标
    private static int findMostLeftIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) return -1;
        int left = 0;
        int right = arr.length - 1;
        int mostLeftIndex = -1;
        while (left <= right) {
            int midIndex = (left + right) / 2;
            if (arr[midIndex] >= num) {
                mostLeftIndex = midIndex;
                right = midIndex - 1;
            } else left = midIndex + 1;
        }
        return mostLeftIndex;
    }

    // 在给定的有序数组中查找<=给定数的最右的位置的下标
    private static int findMostRightIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) return -1;
        int left = 0;
        int right = arr.length - 1;
        int mostRightIndex = -1;
        while (left <= right) {
            int midIndex = (left + right) / 2;
            if (arr[midIndex] <= num) {
                mostRightIndex = midIndex;
                right = midIndex - 1;
            } else left = midIndex + 1;
        }
        return mostRightIndex;
    }
}
