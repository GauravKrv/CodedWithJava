public class Car extends Vehicle {//here we will inherit the properties from the parent class by using public functions by using "extends keyword"
//Also we can declare extra properties for the child class
private boolean powStear = false;
private boolean ledScreen = true;
//Now we will create constructor for objects of this child class
    public Car(String name,String color,String model,String company,int engine,boolean powStear,boolean ledScreen){
        //we need not to instantiate the properties by usig the "this" keyword here,,we can do it as follows bby using
        // super and sending these properties to the parent class to inherit from there.And for new ones we need to instantiate them.
        super(name, color, model, company, engine);
        this.powStear=powStear;
        this.ledScreen=ledScreen;
    }
    public String getName() { //This is called method overriding in OOP
        return "Name of your vehicle is "+super.getName();
    }//super keyword used here will call the parent function getname and concat it wit the cild function return value.

    public void setPowStear(boolean powStear){ //it becomes a function as its name is diff from constructor
        this.powStear=powStear;//
    }
    public void setLedScreen(boolean ledScreen){ //it becomes a function as its name is diff from constructor
        this.ledScreen=ledScreen;//
    }


    public boolean getPowStear() {
        return this.powStear;
    }
    public boolean getLedScreen() { //it becomes a function as its name is diff from constructor
        return this.ledScreen;
    }
    public String getInfo(){
        return "This is a car";
    }
}
