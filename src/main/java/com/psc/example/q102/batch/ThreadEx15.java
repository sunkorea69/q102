package com.psc.example.q102.batch;

public class ThreadEx15 {
    public static void main(String[] args) {
        RunImplEx15 th1 = new RunImplEx15("*");
        RunImplEx15 th2 = new RunImplEx15("**");
        RunImplEx15 th3 = new RunImplEx15("***");

        th1.start();
        th2.start();
        th3.start();
        try {
            Thread.sleep(2000);
            th1.suspend();
            Thread.sleep(2000);
            th2.suspend();
            Thread.sleep(3000);
            th1.resume();
            Thread.sleep(3000);
            th3.suspend();
            th1.stop();
            th2.stop();
            Thread.sleep(3000);
            th3.stop();

        }catch (InterruptedException e) {}
    }

}

class RunImplEx15 implements Runnable{

    volatile boolean suspended = false;
    volatile boolean stopped = false;
    Thread th;
    RunImplEx15 (String name) {
        th = new Thread(this, name);
    }
    public void run () {
        while (!stopped) {
            if(!suspended) {
                System.out.println(Thread.currentThread().getName());
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e) {}
            }
        }
        System.out.println(Thread.currentThread().getName() + "- stopped");
    }
    public void suspend() { suspended = true;}
    public void resume() {suspended = false;}
    public void stop() {stopped = true;}
    public void start() { th.start();}
}
