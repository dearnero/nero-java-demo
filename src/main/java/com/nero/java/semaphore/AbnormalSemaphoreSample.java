package com.nero.java.semaphore;

import java.util.concurrent.Semaphore;

/**
 * 这个场景，在车站、机场等出租车时，当 很多空出租车就位时，
 * 为防止过度拥挤，调度员指挥排队等待坐车的队伍一次进来 5 个人上 车，等这 5 个人坐车出发，再放进去下一批
 * <p>
 * date : 2019-03-01
 * time : 15:16
 * </p>
 *
 * @author Nero
 */
public class AbnormalSemaphoreSample {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(0);
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new MyWorker(semaphore));
            t.start();
        }
        System.out.println("Action...GO!");
        semaphore.release(5);
        System.out.println("Wait for permits off");
        while (semaphore.availablePermits() != 0) {
            Thread.sleep(100L);
        }
        System.out.println("Action...GO again!");
        semaphore.release(5);
    }
}

class MyWorker implements Runnable {
    private Semaphore semaphore;

    public MyWorker(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public void run() {
        try {
            semaphore.acquire();
            System.out.println("Executed!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
