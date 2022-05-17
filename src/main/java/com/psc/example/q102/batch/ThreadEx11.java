package com.psc.example.q102.batch;
 class Ex13_7 implements Runnable{
     public static boolean autoSave = false;

     public static void main(String[] args) {
         Thread t = new Thread(new Ex13_7());

         t.setDaemon(true);
         t.start();

         for ( int i=0;i<=10;i++) {
             try{
                 Thread.sleep(1000);
             }catch (InterruptedException e) {}
             System.out.println(i);
             if(i==5) autoSave = true;
         }
     }
     public void run() {
         while(true) {
             try{
                 Thread.sleep(3 *1000);
             }catch(InterruptedException e){}

             if (autoSave) autoSave();
         }
     }

     public void autoSave() {
         System.out.println("autoSave 자동 저장");
     }
}
