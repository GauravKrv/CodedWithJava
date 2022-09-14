package STREAMS;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P1Lists {

    public static void main(String[] args) {
        List<Integer> list = List.of(2,3,5,4,7,8);
        System.out.println("GIVEN LIST");
        printList(list);
        System.out.println("\n-----------------------\n");
        removeodds(list);
        System.out.println("\n-----------------------\n");
        removeLessThanN(list,4);
        System.out.println("\n-----------------------\n");
        printMin(list);

    }


    public static void removeodds(List<Integer> list){
        //using stream -> remove all the odd numbers from the list
        List<Integer> resultofeven = list.stream().filter(e -> e % 2 == 0).toList();

        //printing new list using map
        resultofeven.stream().map(e -> {
            System.out.print(e+" ");
            return e;
        }).collect(Collectors.toList());
    }

    public static void printList(List<Integer> list){
        list.stream().forEach(e -> System.out.print(e+" "));
    }

    public static void printMin(List<Integer> list){
       int min =  list.stream().min((x,y) -> compare(x,y)).get();

        System.out.println(min);
    }

    public static void printMinString(List<String> list){
       String min =  list.stream().min((x, y) -> compare(x,y)).get();

        System.out.println(min);
    }

    //to compre string
    public static int compare(int x,int y){
        return y>x?-1:1;
    }

    public static int compare(String x,String y){
        return y.compareTo(x);
    }
    public static void removeLessThanN(List<Integer> list,int n){

        //using stream -> remove all the odd numbers from the list
        List<Integer> removeLTn = list.stream().filter(e -> e > n).toList();

        //printing new list using map
        removeLTn.stream().map(e -> {
            System.out.print(e+" ");
            return e;
        }).collect(Collectors.toList());
    }



//        removeodds(list);
//        removeLessThanN(list,4);
}
