public class Lion {
    int age;
    String Colour = "Black";
    Lion(int age,int legs,String Color,String sound){
        this.age=age;
       // this.Colour=Color;


    }
  //  Lion cub = new Lion(4,4,"red","whishper");
    public static void main(String[] args) {
        Animals sher = new Animals(4," dahar "," Yellow.");
        Lion cub = new Lion(4,4,"red","whishper");

        System.out.println("the Lion has "+sher.legs+" legs "+" with "+sher.color+" color and "+sher.sound  +" sound.");
        System.out.println("the cub has "+cub.age+" age "+" with "+cub.Colour+" color and "+sher.sound  +" sound.");
        //if you want to use the object of new made class along with its specific calling like "cub.sound" then you have to declare the sound variable
        //inside the class first which could be inherited in its object through calling tis.sound in constructor,else you cannot use
        //i.e if var is declared but "this" is not attached then null or the value used while declaring the variable is assigned to that variable;

    }
}
