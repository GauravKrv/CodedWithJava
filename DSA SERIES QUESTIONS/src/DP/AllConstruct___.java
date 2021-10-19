package DP;

import java.util.ArrayList;
import java.util.Hashtable;

//WORKS
//SYNTAX PROBLEMS
public class AllConstruct___ {
    static Object allConstructDP(String target, String[] wordbank, Hashtable memo){

        if (memo.containsKey(target)) return memo.get(target);

        ArrayList<ArrayList<String>> arrayList = new ArrayList<>();
        arrayList.add(new ArrayList<>());

        if (target.equals("")) return arrayList;

        ArrayList<ArrayList<String>> result = new ArrayList<>();

        for (String word : wordbank) {
            if (target.indexOf(word) == 0) {

                String suffix = target.substring(word.length());

                ArrayList<ArrayList<String>> suffixways =new ArrayList<>();
                suffixways.addAll((ArrayList< ArrayList<String>>) allConstruct(suffix,wordbank));

                for (ArrayList<String> x : suffixways) {
                    x.add(0,word);
                }

                result.addAll(suffixways);
            }
        }

        memo.put(target,result);
        return result;
    }


    static Object allConstruct(String target, String[] wordbank){

        ArrayList<ArrayList<String>> arrayList = new ArrayList<>();
        arrayList.add(new ArrayList<>());

        if (target.equals("")) return arrayList; //Return a single empty array element arraylist

        ArrayList<ArrayList<String>> result = new ArrayList<>(); //create an array to store the result

        for (String word : wordbank) {
            if (target.indexOf(word) == 0) { //check whether the curr word is the suffix of the target word

                String suffix = target.substring(word.length()); //get the remeainder string after removing the suffix

                ArrayList<ArrayList<String>> suffixways =new ArrayList<>(); //initialise an array for storing the returned value

                suffixways.addAll((ArrayList< ArrayList<String>>) allConstruct(suffix,wordbank)); //store like this and typecast also

                for (ArrayList<String> x : suffixways) {
                    x.add(0,word); //add the current word to start of each array in the list
                }

                result.addAll(suffixways); //adding all the arrays to global arraylist
            }
            }

        return result; //returning the list of arrays
    }

    public static void main(String[] args) {
       // ArrayList<ArrayList<String>> arrayList = new ArrayList<ArrayList<String>>();

        Hashtable<String, ArrayList<ArrayList<String>>> memo = new Hashtable<>();
        String target = "purple";
        String[] wordbank = {"purp","pur","p","le","purpl"};
        System.out.println(allConstruct(target,wordbank));
        System.out.println(allConstructDP(target,wordbank,memo));
    }
}
/*
    static Object allConstruct(String target, String[] wordbank){



        ArrayList<ArrayList<String>> result = new ArrayList<>(1);
        result.add(new ArrayList<String>());
        if (target.equals("")) return result;
        for (String word : wordbank) {
            if (target.indexOf(word) == 0) {

                String suffix = target.substring(word.length());

                ArrayList<ArrayList<String>> suffixways = new ArrayList<>();;
                suffixways.addAll((Collection<? extends ArrayList<String>>) allConstruct(suffix,wordbank));

                System.out.println(suffixways.size());

                for (ArrayList<String> x : suffixways) {
                    System.out.println("hoy");
                    x.add(0,word);
                    System.out.println(x);
                }

                result.addAll(suffixways);
            }
            }

        //System.out.println(result);
        return result;
    }

* */
class Check2DArraylist{
    static Object returnAl(){
        return new ArrayList<>(new ArrayList<>());
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> arrayList = new ArrayList<ArrayList<String>>();

        for (int i=0;i<5;i++){
            arrayList.add((ArrayList<String>) returnAl());
            System.out.println(arrayList.get(i));
        }
        System.out.println();
        for (ArrayList<String> x :
                arrayList) {
            x.add("hello");
        }

        for (ArrayList<String> x :
                arrayList) {
            x.add(0,"hii");
        }

        ArrayList<ArrayList<String>> result = new ArrayList<>();
        result.addAll(arrayList);

        System.out.println(arrayList);
        System.out.println(result);
    }
}
