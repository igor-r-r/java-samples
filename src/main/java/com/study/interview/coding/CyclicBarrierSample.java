package com.study.interview.coding;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierSample {

    public CyclicBarrierSample() {
    }

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        new Thread(new Runner(cyclicBarrier)).start();
        new Thread(new Runner(cyclicBarrier)).start();
        Thread.sleep(2000);
        new Thread(new Runner(cyclicBarrier)).start();
    }

    static class Runner implements Runnable {

        private CyclicBarrier cyclicBarrier;

        Runner(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                System.out.println("Oh, we are almost ready, we have only " + (cyclicBarrier.getParties() - cyclicBarrier.getNumberWaiting()) + " runners left.");
                cyclicBarrier.await();

                System.out.println("Finally I'm running!");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

}

class Child extends CyclicBarrierSample {

}
