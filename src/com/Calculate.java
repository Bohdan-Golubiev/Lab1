package com;

public class Calculate extends Thread{
    private final int id;
    private final TimeController controller;

    public Calculate(int id, TimeController controller) {
        this.id = id;
        this.controller = controller;
    }

    @Override
    public void run() {
        long sum = 0;
        boolean isStop;
        do{
            sum++;
            isStop = controller.isCanBreak();
        } while (!isStop);
        System.out.println("Thread: " + id + " sum - " + sum);
    }
}
