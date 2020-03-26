package com.example.springboot;

/**
 * describe:题目：输入两个正整数m和n，求其最大公约数和最小公倍数
 * 最大公约数：两个数共同的最大约数
 * 最小公倍数：两个数最小的共同倍数
 *
 * @author 林旭南(linxnsz @ sinosoft.com.cn)
 * @date 2020-01-21 下午 03:20
 */
public class GongyueshuAndGongbeishu {
    public static void main(String[] args) {
        int a=24,b=32;
        int c = bigGongYueShu(a,b);
        System.out.println("最大公约数："+c);
        System.out.println("最小公倍数："+a*b/c);
    }

    // 计算两个数的最大公约数,辗转除法
    private static int bigGongYueShu(int n,int m){
        while (true){
            if((m = m % n) == 0){
                return n;
            }
            if((n = n % m) == 0){
                return m;
            }
        }
    }
}
