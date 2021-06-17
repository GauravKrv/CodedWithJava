public class Test1{


        public static int solve(String A) {
           int min = A.length() + 1;
            int indexo;
            int indexx;

            for(int i =0;i<A.length();i++){

                if(A.charAt(i) == 'x'){
                    indexx = i;
                    for(int j =0;j<A.length();j++){
                        if(A.charAt(j) == 'o') {
                            indexo = j;
                            if (min > Math.abs(indexo - indexx)) {
                                min = Math.abs(indexo - indexx);

                            }
                        }

                    }
                }
                else if(A.charAt(i) == 'o')  {
                    indexo = i;
                    for(int j =0;j<A.length();j++){
                        if(A.charAt(j) == 'x') {
                            indexx = j;

                            if (min > Math.abs(indexo - indexx)) {
                                min = Math.abs(indexo - indexx);

                            }
                        }
                    }

                }

            }
            if( min == A.length() + 1){
                return -1;
            }else{
                return min;
            }
        }

    public static void main(String[] args) {
        int i = solve("x..o");
        System.out.println(i);
    }
    }






