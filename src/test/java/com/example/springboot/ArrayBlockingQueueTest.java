package com.example.springboot;

import com.example.springboot.dto.User;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * describe:
 *
 * @author 林旭南(linxnsz @ sinosoft.com.cn)
 * @date 2020-03-25 上午 09:42
 */
public class ArrayBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        final ArrayBlockingQueue<User> queue = new ArrayBlockingQueue<User>(5);
        new Thread(()->{
            for (int i=0;i<10;i++){
               User user = new User();
               user.setId(Long.valueOf(i));
               user.setName("linxunan"+i);
                try {
                    queue.put(user);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread.sleep(100);
        new Thread(()->{
            try {

                while (queue.size() !=0) {
                    System.out.println("消费者："+queue.size());
                    System.out.println(queue.poll(3, TimeUnit.MICROSECONDS));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
