import org.w3c.dom.ls.LSOutput;
public class Animals {
    int legs;
    String sound,color;
     Animals(int legs,String sound,String color){
//         so constructers are used to create a rototype that hoow an object will look in order.
        this.color = color;
        this.sound = sound;
        this.legs = legs;

    }


 //   Animals Lion = new Animals(4,"Roar"," Yellow");  //this is not the right place to create an object
    public static void main(String[] args) {

        Animals tiger = new Animals(4,"Roar"," Brown-Yellow ");
        System.out.println("The object created is"+tiger.color + "in color and has " + tiger.legs +" legs");
    }

}


