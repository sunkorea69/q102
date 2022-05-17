package com.psc.example.q102.batch;

public class ThreadEx20 {
    public static void main(String[] args) {
        ThreadEx20_1 threadEx20_1 = new ThreadEx20_1();
        threadEx20_1.setDaemon(true);
        threadEx20_1.start();
        int requireMemory = 0;
        for (int i = 0; i < 20; i++) {
            requireMemory = (int) (Math.random() * 10) * 20;
            threadEx20_1.useValue += requireMemory;
            System.out.println(requireMemory + " : - : " + threadEx20_1.getUseValue());
            if (threadEx20_1.getUseValue() < 400) {
                threadEx20_1.interrupt();
                try {
                    threadEx20_1.join(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class ThreadEx20_1 extends Thread {
    public int maxValue = 1000;
    public int useValue = 0;

    @Override
    public void run() {
       while(true) {
           try {
               Thread.sleep(10*1000);
               System.out.println("sleep");
           } catch (InterruptedException e) {
               System.out.println("interrup()");
               gc();
           }
       }
    }
    void gc() {
        useValue -= 300;
    }
    int getMaxValue() {
        return this.maxValue;
    }
    int getUseValue() {
        return maxValue - useValue;
    }
}