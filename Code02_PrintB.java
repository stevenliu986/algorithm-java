/**
 * 输入一个整数将该数的二进制数打印出来
 *
 * @author LIU
 */

public class Code02_PrintB {
    public static void main(String[] args) {
        int num = 3456721;
        printBit(num);
    }

    private static void printBit(int num) {
        int numLength = 31;
        for (int i = numLength; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }
}
