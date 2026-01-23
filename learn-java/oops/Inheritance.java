package oops;

public class Inheritance extends parent {
    public static void main(String[] args) {

      Inheritance i = new Inheritance();
        i.display();  
        i.show();
    }
}


 class child {
    void display() {
        System.out.println("This is child class");
    }   
}

class parent extends child {
    void show() {
        System.out.println("This is parent class");
    }   
}

