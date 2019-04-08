package com.study.interview.coding;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchSample {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        Thread runner1 = new Thread(new LatchRunner(countDownLatch));
        Thread runner2 = new Thread(new LatchRunner(countDownLatch));

        runner1.start();
        runner2.start();

        countDownLatch.await();

        System.out.println("Finally counted down!");
    }

    static class LatchRunner implements Runnable {

        private CountDownLatch countDownLatch;

        LatchRunner(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            while (countDownLatch.getCount() > 0) {
                try {
                    System.out.println("Doing smth... meanwhile count is " + countDownLatch.getCount());
                    Thread.sleep(2000);
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
