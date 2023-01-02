package PatternsOops;
/*
Abstract Factory
The Abstract Factory provides an interface for creating families of related or dependent objects without the need
to specify their concrete classes. In the example below the ShapeFactory can be used to create objects based on
the String shapeType. So, we do not need to specify the concrete class,
but only need to pass the type string. This pattern uses inheritance to define the factories that create objects.
* */
import java.awt.*;
//below code is correct - commented means hat the reference classes are not implemented

public abstract class AbstractFactory {
    abstract Color getColor(String color);
    abstract Shape getShape(String shape);
}

class ShapeFactory extends AbstractFactory {

    @Override
   public Shape getShape(String shapeType){

        if(shapeType == null){
            return null;
        }
     /*   if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();

        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();

        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }*/

        return null;
    }

    @Override
    Color getColor(String color) {
        return null;
    }
}

class ColorFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType){
        return null;
    }

    @Override
    Color getColor(String color) {

        if(color == null){
            return null;
        }

      /*  if(color.equalsIgnoreCase("RED")){
            return new Red();

        } else if(color.equalsIgnoreCase("GREEN")){
            return new Green();

        } else if(color.equalsIgnoreCase("BLUE")){
            return new Blue();
        }*/

        return null;
    }
}


