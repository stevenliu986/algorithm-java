/**
 * 计算一个数的阶乘的和，例如： 输入5 得到 5！+4！+3！+2！+1! +0!
 */
public class Code01_SumOfFactorial {
    public static void main(String[] args) {
        long result = getFactorial(8);
        System.out.println(result);
    }

    public static long getFactorial(int num) {
        long ans = 0;
        long cur = 1;
        for (int i = 1; i <= num; i++) {
            cur = cur * i;
            ans += cur;
        }
        return ans;
    }
}
