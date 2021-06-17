public class Bike extends Vehicle {
    private boolean fourstroke = true;

    public Bike(String name,String color,String model,String company,int engine,boolean fourstroke){
        super(name, color, model, company, engine);
        this.fourstroke=fourstroke;
    }

    public void setFourstroke(boolean fourstroke){ //it becomes a function as its name is diff from constructor
        this.fourstroke=fourstroke;//
    }


    public boolean getFourstroke() {
        return this.fourstroke;
    }
    public String getInfo(){
        return "This is a bike";
    }
}
