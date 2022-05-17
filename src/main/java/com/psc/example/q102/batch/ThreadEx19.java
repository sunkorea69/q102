package com.psc.example.q102.batch;

public class ThreadEx19 {
    public static void main(String[] args) {
        long startTime = 0;
        RunImplEx19_1  th1 = new RunImplEx19_1();
        RunImplEx19_2  th2 = new RunImplEx19_2();
        th1.start();
        th2.start();
        startTime = System.currentTimeMillis();

        try {
            th1.join();
            th2.join();
        }catch (InterruptedException e){}

        System.out.println("걸린시간 : " + (System.currentTimeMillis() - startTime));

    }
}

class RunImplEx19_1 extends Thread {

    public void run () {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {}
            System.out.print(Thread.currentThread().getName());
        }
    }
}
class RunImplEx19_2 extends Thread {

    public void run () {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {}
            System.out.print(Thread.currentThread().getName());
        }
    }
}
