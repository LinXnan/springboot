package com.example.springboot;

/**
 * describe:题目：将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5
 *
 * @author 林旭南(linxnsz @ sinosoft.com.cn)
 * @date 2020-01-21 上午 10:33
 */
public class FenJieTest {

    public static void main(String[] args) {
        int number = 81 * 81;
        fengjie(number);
    }
    //主逻辑
    public static void fengjie(int j) {
        // 按照我的理解，开方的作用比如，81= 9* 9，那么他的公因数肯定在 0-9之间
        for (int i = 2; i <= Math.sqrt(j); i++) {
            //这个if是找最小公约数
            if (j % i == 0) {
                System.out.print(i + "*");
                //这个if是判断他是不是素数，如果是素数，就将这个数输出，然后就执行break;了
                if (isPrime(j / i)) {
                    System.out.print(j / i);
                } else {
                    //如果不是素数，就继续分解，找公约数
                    fengjie(j / i);
                    break;
                }
            }
        }
    }
    //判断是否是素数
    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
