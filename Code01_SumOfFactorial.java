/**
 * 计算一个数的阶乘的和，例如： 输入5 得到 5！+4！+3！+2！+1! +0!
 */
public class Code01_SumOfFactorial {
    public static void main(String[] args) {
        int result = getFactorial(8);
        System.out.println(result);
    }

    public static int getFactorial(int num) {
        int temp = 0;
        for (int i = 0; i <= num; i++) {
            temp += factorial(i);
        }
        return temp;
    }

    public static int factorial(int num) {
        if (num <= 1) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }
}
