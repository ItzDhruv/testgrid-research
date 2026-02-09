package org.example;

public class Main {


   public static void main(String[] args) throws InterruptedException {

        myThread t = new myThread();
        World world = new World();
        Thread t2 = new Thread(world);  //  implements Runnable not make class thread we pass that instance at Thread to make that class thread
        t2.run();


        for(int i =0;i<10;i++){

            t.run(i);


            Thread.sleep(1000 * i);
        }
    }



    public static void threadExample() {

        for (int i = 0; i < 5; i++) {

            int id = i;

            new Thread(() -> {
                System.out.println("Task: " + id);
            }).start();
        }
    }
}


 class myThread extends Thread {

     public void run(int i) {
         System.out.println("Wait for second  : "+i);
     }

 }
