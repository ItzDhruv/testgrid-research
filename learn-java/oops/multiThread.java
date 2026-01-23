package oops;

class multiThread  {
  

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.start();
        b.start();
    }
}

class A extends Thread {
   public void run() {
       for (int i = 1; i <= 100; i++) {
           System.out.println("From A --------: " + i);
           try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
       }
    }
}

class B extends Thread {
    public void run() {
       for (int i = 1; i <= 100; i++) {
           System.out.println("From B " + i);
           try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
       }
    }
}