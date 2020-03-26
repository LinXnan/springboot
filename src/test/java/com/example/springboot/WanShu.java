package com.example.springboot;

/**
 * describe: 题目：一个数如果恰好等于它的因子之和，这个数就称为 "完数 "。例如6=1＋2＋3.编程 找出1000以内的所有完数。
 *
 * @author 林旭南(linxnsz @ sinosoft.com.cn)
 * @date 2020-01-21 下午 03:56
 */
public class WanShu {
    public static void main(String[] args) {
        for (int i=1;i<=10;i++){
            int sum = 1;
            wanShu(i,sum,i);
        }
    }

    // 计算完数的方法逻辑
    private static void wanShu(int a,int sum,int b){
        for(int i=2;i<=Math.sqrt(a);i++){
            if(a % i == 0){
                sum = sum +i;
                if(isPrime(a / i)){
                    sum = sum + a/i;
                }else{
                    wanShu(a/i,sum,b);
                    break;
                }
            }
        }
        if(sum == b){
            System.out.println(b);
        }
    }

    private static boolean isPrime(int a){
        for(int i=2;i<=Math.sqrt(a);i++){
            if(a % i == 0){
                return false;
            }
        }
        return true;
    }
}
