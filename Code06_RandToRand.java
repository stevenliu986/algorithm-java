/**
 * 由给定的一个函数f，该函数等概率随机产生[1,5]的数。
 * 利用该函数生成一个等概率随机产生[1,7]有函数g
 */
public class Code06_RandToRand {
    public static void main(String[] args) {
        // 测试f4函数
        int[] counts = new int[8];
        int testTimes = 10000000;
        for (int i = 0; i < testTimes; i++) {
            int num = f4();
            counts[num]++;
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println(i + "这个数出现了" + counts[i] + "次");
        }
    }

    // 等概率随机函数，产生的数在区间[1,5]中
    private static int f1() {
        return (int) (Math.random() * 5) + 1;
    }

    // 只能使用f1函数，等概率返回0，1
    private static int f2() {
        int ans;
        do {
            ans = f1();
        } while (ans == 3);
        return ans < 3 ? 0 : 1;
    }

    // 得到000 ~ 111，做到等概率0 ~ 7返回一个
    private static int f3() {
        return (f2() << 2) + (f2() << 1) + f2();
    }

    // 1 ~ 7等概率返回一个
    private static int f4() {
        int ans;
        do {
            ans = f3();
        } while (ans == 0);
        return ans;
    }
}
