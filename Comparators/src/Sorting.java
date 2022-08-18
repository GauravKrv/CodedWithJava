import java.util.*;
public class Sorting {
    static class Node{
        int x;
        int y;

        String name;
        Node(int x_,int y_){
            x=x_;
            y=y_;
        }

        Node(int x_,int y_, String name_){
            x=x_;
            y=y_;
            name=name_;
        }
    }
/*
INPUT
1 2 hek
3 1 hek
4 0 wozam
5 4 abla
3 2 abla
* * */
    public static void main(String[] args) {
        sort3x();
    }

    static void sort2x(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Node> al = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            al.add(new Node(sc.nextInt(),sc.nextInt(), sc.next()));
        }

        //comparator sorting
        Collections.sort(al, (o1, o2) -> {
            if (o1.name.compareTo(o2.name)>0){
                return 1;
            }
            else if (o1.name.compareTo(o2.name)<0){
                return -1;
            }
            else {
                if (o1.y>o2.y){
                    return 1;
                }
                else if (o1.y<o2.y){
                    return 1;
                }else {

                    return 0;
                }
            }
        });

        for (Node x :
                al) {
            System.out.println(x.x+" "+x.y+" "+x.name);
        }
    }

    static void sort3x(){
        System.out.println(" input x y and string ");
        Scanner sc = new Scanner(System.in);
        ArrayList<Node> al = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            al.add(new Node(sc.nextInt(),sc.nextInt(), sc.next()));
        }

        //comparator sorting
        Collections.sort(al, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.name.compareTo(o2.name)>0){
                    return 1;
                }
                else if (o1.name.compareTo(o2.name)<0){
                    return -1;
                }
                else {
                    if (o1.y>o2.y){
                        return 1;
                    }
                    else if (o1.y<o2.y){
                        return -1;
                    }else {

                        if (o1.x>o2.x){
                            return 1;
                        }
                        else if (o1.x<o2.x){
                            return -1;
                        }else {

                            return 0;
                        }
                    }
                }
            }
        });
        System.out.println("sorted in name->y->x order");
        for (Node x :
                al) {
            System.out.println(x.x+" "+x.y+" "+x.name);
        }
    }
    /*
1 2 hek
3 1 hek
4 0 wozam
5 4 abla
3 2 abla*/
}

class Temp{
    static int[] solve(int i,int a[],int[] res,int x,int c){
     if (i==a.length) return res;
     if (a[i]==x){
         res[c]=i;
         c++;
     }

    return solve(i+1, a, res, x, c);
    }

    public static void main(String[] args) {
        int a[] = {1, 4 ,2 ,6, 2 , 2, 5, 2};
        int x = 2;
        int[] res = new int[a.length];
        res = solve(0,a,res,x,0);
        for (int j :
                res) {
            if (j==0) break;
            System.out.print(j+" ");
        }
    }
}
