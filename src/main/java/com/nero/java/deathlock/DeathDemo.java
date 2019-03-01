package com.nero.java.deathlock;

/**
 * <p>
 * date : 2019-03-01
 * time : 14:43
 * </p>
 *
 * @author Nero
 */
public class DeathDemo extends Thread {

    private String first;
    private String second;

    public DeathDemo(String name, String first, String second) {
        super(name);
        this.first = first;
        this.second = second;
    }

    public void run() {
        synchronized (first) {
            System.out.println(this.getName() + " obtained: " + first);
            try {
                Thread.sleep(1000L);
                synchronized (second) {
                    System.out.println(this.getName() + " obtained: " + second);
                }
            } catch (InterruptedException e) {
                // Do nothing
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String lockA = "lockA";
        String lockB = "lockB";
        DeathDemo t1 = new DeathDemo("Thread1", lockA, lockB);
        DeathDemo t2 = new DeathDemo("Thread2", lockB, lockA);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
