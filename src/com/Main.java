package com;

public class Main {

    public static void main(String[] args) {
        int threadCount = 7;

        int[] times = {8000, 5000, 9000, 7000, 10000, 5000, 7000};

        boolean[] canStop = new boolean[threadCount];
        Calculate[] threads = new Calculate[threadCount];

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Calculate(i, canStop, times[i]);
            threads[i].start();
        }

        new Thread(new TimeController(times, canStop)).start();
    }
}