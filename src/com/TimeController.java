package com;

public class TimeController implements Runnable{
    private final int[] times;
    private volatile boolean[] canStop;

    public TimeController(int[] times, boolean[] canStop) {
        this.times = times.clone();
        this.canStop = canStop;
    }

    @Override
    public void run() {
        int threadCount = times.length;
        int[] indexes = new int[threadCount];
        for (int i = 0; i < threadCount; i++) indexes[i] = i;

        for (int i = 0; i < threadCount - 1; i++) {
            for (int j = 0; j < threadCount - i - 1; j++) {
                if (times[j] > times[j + 1]) {
                    int tmpTime = times[j];
                    times[j] = times[j + 1];
                    times[j + 1] = tmpTime;

                    int tmpIndex = indexes[j];
                    indexes[j] = indexes[j + 1];
                    indexes[j + 1] = tmpIndex;
                }
            }
        }

        int prevTime = 0;

        for (int i = 0; i < threadCount; i++) {
            int index = indexes[i];
            int currentTime = times[i];

            int sleepTime = currentTime - prevTime;

            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            canStop[index] = true;
            prevTime = currentTime;
        }
    }
}
