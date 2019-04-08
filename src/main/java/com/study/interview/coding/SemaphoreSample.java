package com.study.interview.coding;

import java.util.concurrent.Semaphore;

public class SemaphoreSample {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);

        buildSemaphoreUserThread(semaphore).start();
        buildSemaphoreUserThread(semaphore).start();
        buildSemaphoreUserThread(semaphore).start();
        buildSemaphoreUserThread(semaphore).start();
        buildSemaphoreUserThread(semaphore).start();
        buildSemaphoreUserThread(semaphore).start();
        buildSemaphoreUserThread(semaphore).start();
        buildSemaphoreUserThread(semaphore).start();
    }

    private static Thread buildSemaphoreUserThread(Semaphore semaphore) {
        return new Thread(new SemaphoreUser(semaphore));
    }

    static class SemaphoreUser implements Runnable {
        private Semaphore semaphore;

        SemaphoreUser(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                System.out.println("Trying to acquire semaphore... ");
                semaphore.acquire();
                System.out.println("Acquired!!1 Happily playing with it for a while...");
                Thread.sleep(2000);
                System.out.println("Ok, let someone else play.");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
