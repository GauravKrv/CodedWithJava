package Patterns.adapter;

public class User {
    private final MemoryCard memoryCard;

    public User(MemoryCard memoryCard) {
        this.memoryCard = memoryCard;
    }

    public void makeLaptopCompatible(){
        memoryCard.makeLaptopCompatible();
    }

    public static void main(String[] args) {
        var user = new User(new Adapter());
        user.makeLaptopCompatible();
    }
}
