package EduRound120;

import CodeForces.CodeForces;

import java.util.ArrayList;
import java.util.Collections;

//check if works or not....on 18th jan -- workss test case1
public class B extends CodeForces {
    static String soluiton(int n,int[] perm, String bin) {
        ArrayList<Integer> like = new ArrayList<>();
        ArrayList<Integer> dislike = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (bin.charAt(i) == '1') {
                like.add((perm[i]));
            }else if (bin.charAt(i) == '0')
                {
                    dislike.add((perm[i]));
                }

        }

            ArrayList<Integer> sorted = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                sorted.add((perm[i]));
            }

        Collections.sort(like);
        Collections.sort(dislike);
        Collections.sort(sorted);


        /*System.out.println(like);
        System.out.println(dislike);

        System.out.println(sorted);*/

        ArrayList<Integer> result = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            int l,d,curr_inserting_element;
            if (like.contains(perm[i]))  {
                l = like.indexOf((perm[i]));
                curr_inserting_element = sorted.get(dislike.size()+l);
            }else{
                d = dislike.indexOf((perm[i]));
                curr_inserting_element = sorted.get(d);
            }

            result.add(curr_inserting_element);


        }

            return result.toString();



    }
    public static void main(String[] args) {
        int t = I();

        while(t-->0) {
            int n = I();
            int[] perm = new int[n];

            for (int i = 0; i < n; i++) {
                perm[i] = I();
            }

            String bin = S();

            System.out.println(soluiton(n,perm,bin));

        }


    }

}
