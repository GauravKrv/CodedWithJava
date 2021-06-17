import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class BeautifulPermutation {


        public static void main(String[] args)  throws java.lang.Exception  {

            Scanner sc = new Scanner(System.in);
            int test, N;

            test = sc.nextInt();
            for(int i=0;i<test;i++){
                Vector<Integer> aL = new Vector<>();
                Stack<Integer> st = new Stack<>();
                int iter=2,current=1,top=-1;
                N = sc.nextInt();
                double check = Math.pow((double)2,Math.log((double)N)/Math.log((double)2));

                aL.add(1);
                for(int j=0;j<N;j++) {
                    /*if(check == (double)N ){
                        System.out.println(-1);
                        break;
                    }else {*/


                    if(top>-1){
                        if((current & st.peek())>0){
                            while( (top>-1)&&((current & st.peek())>0)){
                                System.out.println("work="+j);
                                current = st.firstElement();
                                st.pop();
                                top--;
                                aL.add(current);
                            }
                        }
                    }
                 if((iter & current)>0 ) {
                     System.out.println("work2="+j);
                     aL.add(current);
                     current= iter;
                     ++iter;

                 }
                 else if((iter&current)==0){
                     System.out.println("work3="+j);
                     if (top==-1)
                     top = 0;
                     else
                         top++;

                     st.push(iter);

                     iter++;

                 }
                }
                if(current>1)
                System.out.println(aL);
            }
        }
    }



