public class Q1  {
    /*o/p->
1*****
12****
123***
1234**
12345*
123456
    public static void main(String[] args) {
        int row,column,i,j;
        for(i=1;i<=6;i++){
            for(j=1;j<=6;j++){
                if(j==i || j<i){
                    System.out.print(j);
                }else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }*/
   /*o/p->
12345&
1234&&
123&&&
12&&&&
1&&&&&
&&&&&&
    public static void main(String[] args) {
        int row,column,i,j;
        for(i=6;i>0;i--){
            for(j=1;j<=6;j++){
                if(j<i ){
                    System.out.print(j);
                }else {
                    System.out.print("&");
                }
            }
            System.out.println();
        }
    }*/
    public static void main(String[] args) {
        /*
 o/p:
@
@ @
@   @
@     @
@       @
@ @ @ @ @ @

        * */
        int row,column,i,j;
        for(i=1;i<=6;i++){
            for(j=1;j<=6;j++){
                if(j==i||j==1 ||i==6  ){
                    System.out.print("@ ");
                }else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
