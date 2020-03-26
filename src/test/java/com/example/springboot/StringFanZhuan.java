package com.example.springboot;

/**
 * describe:写一个字符串反转函数
 *
 * @author 林旭南(linxnsz @ sinosoft.com.cn)
 * @date 2020-01-21 下午 04:54
 */
public class StringFanZhuan {
    public static void main(String[] args) {
        System.out.println(reverse("linxunan"));
    }

    // 采用递归的方式
    private static String reverse(String s){
        if(s.length() == 1)
            return s;
        String left = s.substring(0,s.length()/2);
        String right = s.substring(s.length()/2,s.length());
        return reverse(right) + reverse(left);
    }
}
