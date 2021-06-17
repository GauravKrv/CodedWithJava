public class Vehicle {

    private String name = ""; //these are made private as we have already declared getters for these props so that these cannot be directly used
    private String color= "";
    private String model= "";
    private String company = "";      //these 4 props are commen in all vehicles for example.
    private int engine = 800;
    public static int count;  //static keyword makes the property static and if its changed in one object then change will be same for others as well.
    public Vehicle(){
        count++;
        //an empty comnstructor and tif the name of constrctr is not same as class ten it becomes a function
    }
    public Vehicle(String name2,String color,String model,String company,int engine){ //here the property names in constructor may be different..
       //Here LHS=class property declrd and RHS = constructor variales declared.
        this.name=name;
        this.color=color;
        this.company=company;
        this.model=model;
        this.engine=engine;
        count++;
    }
    //HOW CAN WE CREATE MULTIPLE FUNCTIONS FOR INDIVIDUAL PROPRTS OF CLASS.BELOW:
    //we use public so that we can use these functions outside theis class
    //the set functions are usedin the way so that they can used to set the value for diff props of class
     public void setName(String name){ //it becomes a function as its name is diff from constructor
            this.name=name;//it tells that the value of name for the class can be modified by calling tis function and passing the value in the function
            //which will invoke this function and will set class property of nname as passsed value.
    }
    public void setModel(String model){ //it becomes a function as its name is diff from constructor
        this.model=model;//
    }
    public void setColor(String color){ //it becomes a function as its name is diff from constructor
        this.color=color;//
    }
    public void setCompany(String company){ //it becomes a function as its name is diff from constructor
        this.company=company;//
    }
    public void setEngine(int engine){ //it becomes a function as its name is diff from constructor
        this.engine=engine;

    }

    //    //the get functions are usedin the way so that they can be used to get the value for diff props of class as******** it is not good practice
    //to get the values directly from class declarations due to security reasons
    public String getName() { //it becomes a function as its name is diff from constructor
        return this.name;
    }
    public String getModel() { //it becomes a function as its name is diff from constructor
        return this.model;
    }
    public String getColor() { //it becomes a function as its name is diff from constructor
        return this.color;
    }
    public String getCompany() { //it becomes a function as its name is diff from constructor
        return this.company;
    }
    private int getEngine() { //it becomes a function as its name is diff from constructor
        return this.engine;
    }
    public int getSpeed() { //it becomes a function as its name is diff from constructor
       int a =getEngine();
       if(a == 800){
           return 90;
       }else{
           return 120;
       }

    }
    public String getInfo(){
        return "This is a vehicle";
    }
    //IF WE WANT TO CALL A SPECIFIC FUNCTION OF A CLASS WITHOUT USING ANY OBJECT THEN WE CAN DO THIS BY USING STATIC KEYWORD IN FUN DECLARATION->
    public static String getVeh(){
        return "we got vehicle from static directly";
    }



}
