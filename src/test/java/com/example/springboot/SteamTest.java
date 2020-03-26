package com.example.springboot;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * describe:
 *
 * @author 林旭南(linxnsz @ sinosoft.com.cn)
 * @date 2020-03-02 下午 03:02
 */
public class SteamTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.stream().forEach(name -> System.out.println("序号：" + name));
    }
}
