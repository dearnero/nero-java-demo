package com.nero.java.semaphore;

import java.util.concurrent.Semaphore;

/**
 * <p>
 * date : 2019-03-01
 * time : 15:08
 * </p>
 *
 * @author Nero
 */
public class UsualSemaphoreSample {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Action...GO!");
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new SemaphoreWorker(semaphore));
            t.start();
        }
    }
}

class SemaphoreWorker implements Runnable{

    private String name;
    private Semaphore semaphore;

    public SemaphoreWorker(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public void run() {
        try {
            log("is waiting for a permit!");
            semaphore.acquire();
            log("acquired a permit!");
            log("executed!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            log("released a permit!");
            semaphore.release();
        }
    }

    private void log(String msg) {
        if (name == null) {
            name = Thread.currentThread().getName();
        }
        System.out.println(name + " " + msg);
    }

}
