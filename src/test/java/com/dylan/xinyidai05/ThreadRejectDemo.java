package com.dylan.xinyidai05;

import java.util.concurrent.*;

/**
 * @author baoxiang
 * @create 2020-07-17 9:35
 */
public class ThreadRejectDemo {

    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>();
        ThreadFactory factory = r -> new Thread(r, "test-thread-pool");
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10,
                0L, TimeUnit.SECONDS, queue, factory);
        int i =0;
        while (++i<=1100) {
            executor.submit(() -> {
                try {
                    System.out.println(queue.size());
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
//        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
//        threadPoolTaskExecutor.getThreadPoolExecutor();
    }
}
 