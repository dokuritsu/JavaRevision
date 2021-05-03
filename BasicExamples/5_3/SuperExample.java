public class SuperExample extends Shape{

    /*  Difference between super() and this keyword
        Created a child object
            => calls its constructor => indirectly calls super() => parent constructor
    */

    SuperExample(){
        System.out.println("Child class no arg constructor");
    }

    public static void main(String[] args){
        new SuperExample();
        System.out.println("Inside main");

        new Rectangle();
        System.out.println("Inside main");
    }
}

class Shape {

    Shape(){
        System.out.println("Parent shape class no arg constructor");
    }    
}

class Rectangle extends Shape {
    int length;
    int width;

    Rectangle(){

        // Exampe of this keyword: invoke the current class constructor
        this(10, 10);
        System.out.println("Child class of shape with no arg constructor");
    }

    Rectangle(int x, int y){
        // Example of this keyword: indicates the current class variable
        this.length = x;
        this.width = y;
        System.out.println("Child class of shape with args");
    }
}