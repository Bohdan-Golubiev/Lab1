package com;

public class Main {
    public static void main(String[] args) {
        int count = 4;
        TimeController controller = new TimeController();
        for(int i=0;i<count;i++)
        {
            int num = i+1;
            new Calculate(num, controller).start();
        }
        new Thread(controller).start();
    }
}