package oops;

public class abstraction  {
    public static void main(String[] args) {

        Dog d = new Dog();
        d.Color();
        d.eat();

        Sparrow s = new Sparrow();
        s.birdSound();
        s.eat();

        Duck dk = new Duck();
        dk.birdSound();
        dk.eat();
        dk.Color();

        peacock p = new peacock();
        p.Color();          
        p.eat();
        p.birdSound();
        p.breath(); 
    }

   
}


class Dog implements Animal {

    public void Color(){
            System.out.println("White"); 
    }
    

    public void eat(){
        System.out.println("Dog is eating");
    }


}

class Sparrow implements Bird {

    public void birdSound(){
            System.out.println("Brown"); 
    }
    

    public void eat(){
        System.out.println("Bird is eating");
    }

    
}


class Duck implements Bird, Animal {

    public void birdSound(){
            System.out.println("Quack Quack"); 
    }
    

    public void eat(){
        System.out.println("Duck is eating");
    }

    public void Color(){
        System.out.println("White");
    }
}

class peacock implements insect {

    public void Color(){
            System.out.println("Colorful"); 
    }
    

    public void eat(){
        System.out.println("Peacock is eating");
    }

    public void birdSound(){
        System.out.println("Peacock sound");
    }

    public void breath(){
        System.out.println("Peacock is breathing");
    }
}


interface Animal {
    void Color();
    void eat();
}


interface Bird {
    void birdSound();
    void eat();
}


// inherites interfaces
interface insect extends Animal, Bird {
    void breath();
}