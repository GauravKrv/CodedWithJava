package GenericsW1;

public class W1L5Animal {
    long lifespan;
    float weight;
    W1L5Animal(long years, float kgs){
        lifespan = years;
        weight = kgs;

    }
    public void print(){
        System.out.println("Max life = "+lifespan+" in years");
        System.out.println("Max weight= "+weight + " in kgs");
    }
}

class Aquatic extends W1L5Animal {
    boolean scale;
    Aquatic(long years, float kgs, boolean scale){
        super(years,kgs);
        this.scale = scale;
    }
    public void print(){
        super.print(); // Call the super class method-->method overriding
        System.out.println("Scale = "+ scale);
    }
} // End of class Aquatic
// Continued to next...

class Land extends W1L5Animal {
    int vision; //0 = nocturnal, 1 = only day light, 2 = both
    Land(long years, float kgs, int vision) {
        super(years, kgs); // Super class constructor
        this.vision = vision;
    }
} // End of class Land

class Pet extends Land {
    String name;
    Pet(long years, float kgs, int vision, String name) {
        super(years, kgs, vision); // Super class constructor
        this.name = name;
    }
} // End of class Pet

// Continued to next...
class Wild extends Land {
    float speed; // Maximum running speed in mph
    Wild(long years, float kgs, int vision, float speed) {
        super(years, kgs, vision); // Super class constructor
        this.speed = speed;
    }
} // End of class Wild

class AnimalWorld <T extends W1L5Animal> {
    //Type parameter is limited to Animal and its sub classes

    T  listOfAnimals[];
    AnimalWorld(T list[ ] ) {// Generic constructor to create a list of type T
    listOfAnimals = list;
}
} // End of the generic class AnimalWorld

// Continued to next...
class BoundedWildcards {
    //Case 1: Unbound wildcard: Any object can be passed as its argument.
   public static void vitality(AnimalWorld<?> animals) {
//To print the vitality of animals in the list of animals
        for (int i = 0; i < animals.listOfAnimals.length; i++) {
            animals.listOfAnimals[i].print();
        }
    }
// Continued to next...
// Case 2: Lower bounded wildcard: Any object of Aquatic or Animal can // be
//passed as its argument.
    static void showSea(AnimalWorld<? super Aquatic> animals) {
//For aquatic or unknown animals
       /* for(Object obj : animals)
            obj.print();
// Call the method defined in Animal/ Aquatic class
        System.out.println();
    */
    }


    // Case 3a: Upper bounded wildcard: Any object of Land/ Pet/ Wild can // be
  //  passed as its argument.
    static void showLand(AnimalWorld<? extends Land> animals) {
//For Land or any of its subclasses
        for(int i = 0; i < animals.listOfAnimals.length;i++) {
            animals.listOfAnimals[i].print();
// Call the method defined in Animal class
            System.out.println("Vision : "+ animals.listOfAnimals[i].vision);
        }
        System.out.println();
    }
// Continued to next...
// Case 3b: Upper bounded wildcard: Any object of only Pet class can // be
//passed as its argument.

    static void showPet(AnimalWorld<? extends Pet> animals) {
//For lists of Pet objects only
        for(int i = 0; i < animals.listOfAnimals.length;i++) {
            System.out.println("Pet’s name: " + animals.listOfAnimals[i].name);
            animals.listOfAnimals[i].print();
// Call the method defined in Animal class
            System.out.println("“Vision : “" + animals.listOfAnimals[i].vision);
        }
        System.out.println();
    }

    // Case 3c: Upper bounded wildcard: Any object of only Wild class can // be
   // passed as its argument.
    static void showWild(AnimalWorld<? extends Wild> animals) {
//For objects of Wild class only
        for(int i = 0; i < animals.listOfAnimals.length;i++) {
            animals.listOfAnimals[i].print();
// Call the method defined in Animal class
            System.out.println("“Maximum running speed: “" + animals.listOfAnimals[i].speed + "“ in mph”");
            System.out.println("Vision : “" + animals.listOfAnimals[i].vision);
        }
        System.out.println();
    }
} // End of the method definitions in class BoundedWildcards

class BoundedWildcardArgumentsDemo {
    public static void main(String args[]) {
// Create a list of unknown animals of class Animal
        W1L5Animal unknown = new W1L5Animal(40, 720);
// An unknown animal object is created
        W1L5Animal u[] = {unknown}; // Array of unknown animals
        AnimalWorld<W1L5Animal> uList = new AnimalWorld<W1L5Animal>(u);
// Place the unknown into a list
// Create a list of aquatic animals
        Aquatic whale = new Aquatic(90, 150000,true);
// A whale object is created
        Aquatic shark = new Aquatic(400, 2150,true);
// A shark object is created
        Aquatic q[] = {whale, shark};
// Array of aquatic animals
        AnimalWorld<Aquatic> qList = new AnimalWorld<Aquatic>(q);
// Place the aquatics into a list

// Create a list of land animals
        Land owl = new Land(3, 1, 0);
// A land owl object is created
        Land l[] = {owl}; // An array of land objects is created
        AnimalWorld<Land> lList = new AnimalWorld<Land>(l);
// Place the animals into a list
// Create a list of pet animals
        Pet dog = new Pet(15, 75, 2, "“Prince”");
// A pet dog object is created
        Pet p[] = {new Pet(15, 75, 2, "“Prince”")};
// An array of pet objects is created
        AnimalWorld<Pet> pList = new AnimalWorld<Pet>(p);
// Place the pets into a list

// Create a list of wild animals
        Wild cheetah = new Wild(15, 75, 2,320);
// A cheetah object is created
        Wild deer = new Wild(10, 50, 1,300);
// A deer object is created
        Wild w[] = {cheetah, deer};
// Array of non-aquatic animals
        AnimalWorld<Wild> wList = new AnimalWorld<Wild>(w);
// Place the wilds into a list
// Continued to next...
// Call the methods and see the outcomes
// vitality(…) is with unlimited wildcard argument and
// hence we can pass argument of any type

        BoundedWildcards.vitality(uList); // OK
        BoundedWildcards.vitality(qList); // OK
        BoundedWildcards.vitality(lList); // OK
        BoundedWildcards.vitality(pList); // OK
        BoundedWildcards.vitality(wList); // OK
// Continued to next...
// showSea(…) is with lower bound wildcard argument with
// class Aquatic and its super classes
        BoundedWildcards.showSea(uList); // OK
        BoundedWildcards.showSea(qList); // OK
        // showSea (lList); // Compile-time error
        // showSea (pList); // Compile-time error
        // showSea (wList); // Compile-time error

        BoundedWildcards.showLand(lList);
        BoundedWildcards.showLand(pList);
        BoundedWildcards.showLand(wList);


        BoundedWildcards.showPet(pList);

        BoundedWildcards.showWild(wList);


    }
}//TWO MORE PAGE TEST CASES