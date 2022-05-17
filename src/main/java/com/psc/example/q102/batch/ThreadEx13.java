package com.psc.example.q102.batch;

import javax.swing.*;

public class ThreadEx13 {
    public static void main(String[] args) {
        ThreadEx13_1 th1 = new ThreadEx13_1();
        th1.start();
        String input = JOptionPane.showInputDialog("아무값이나 입력하세요");
        System.out.println("입력한값 :"+ input);
        th1.interrupt();
        System.out.println("IsInterrupted :" + th1.isInterrupted());
        System.out.println("IsInterrupted :" + th1.isInterrupted());
        System.out.println("Thread.interrupted :" + Thread.interrupted());
        System.out.println("Thread.interrupted :" + Thread.interrupted());
    }
}

class ThreadEx13_1 extends Thread {
    public void run() {
        int i = 10;
        System.out.println("init_13_1 IsInterrupted :" + isInterrupted());
        while (i!=0 && !isInterrupted()){
            System.out.println(i--);
            for (long x=0; x<25000000000L;x++) ;
        }
        System.out.println("while after 13_1 IsInterrupted :" + isInterrupted());
        System.out.println("13_1 Thread.interrupted :" + interrupted());
        System.out.println("while after 13_1 IsInterrupted :" + isInterrupted());
        System.out.println("while after 13_1 IsInterrupted :" + isInterrupted());
        System.out.println("카운트가 종료되었습니다");

    }
}
