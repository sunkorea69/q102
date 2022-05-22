package com.psc.example.q102.batch;

import java.util.ArrayList;
import java.util.Random;

public class ThreadEx21 {
    public static void main(String[] args) {
        Runnable r = new RunableEx21_1();
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
        System.out.println("A");

    }
}

class Account {
    private int balance = 1000;
    public int getBalance() {
        return balance;
    }
    public void withdraw(int money) {
        if(balance >= money) {
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {}
            balance -= money;
        }
    }
}

class RunableEx21_1 implements Runnable {
    Account account = new Account();

    @Override
    public void run() {
        while (account.getBalance()>0) {
            int money = (int) (Math.random() *3 + 1) * 100;
            account.withdraw(money);
            System.out.println("balance:" + account.getBalance());
        }

    }
}