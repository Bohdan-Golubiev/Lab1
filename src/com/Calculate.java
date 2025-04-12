package com;

public class Calculate extends Thread{
    private final int index;
    private volatile boolean[] canStop;
    private final int time;

    public Calculate(int index, boolean[] canStop, int time) {
        this.index = index;
        this.canStop = canStop;
        this.time = time;
    }

    @Override
    public void run() {
        long sum = 0;
        while (!canStop[index]) {
            sum++;
        }
        System.out.println("Потік " + (index + 1) + " Сума: " + sum + " Час: " + time + " сек.");
    }
}
