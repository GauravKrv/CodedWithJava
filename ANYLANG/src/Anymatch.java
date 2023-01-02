import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Anymatch {

    public static void main(String[] args) {
        List<Integer> al = new ArrayList<>();
        al.add(2);
        al.add(4);

        if (al.stream().filter(e->e.equals(3)).collect(Collectors.toList())
                .stream().anyMatch(e->e.equals(4))){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
}
