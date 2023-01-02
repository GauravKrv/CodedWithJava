public class AmzWow {

    public static void main(String[] args) {
        int n = 10;
        AmzWow a = new AmzWow();
        System.out.println(a.bitwise(n));
    }

    public  String bitwise(int input1) {
        int countsb = count(input1);
        int lsb = getlsb(input1);
        int msb = getmsb(input1);
        return countsb+"#"+lsb+"#"+msb;
    }

     int count(int n)
    {
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
    //msb
    public  int getlsb(int n)
    {
        int pos = 0;
        while (n>0){
            if ((n&1)==1) return pos;
            pos++;
            n=n/10;
        }
        return pos;
    }
    public  int getmsb(int n)
    {
        int msb = 0;
        n = n / 2;
        while (n != 0) {
            n = n / 2;
            msb++;
        }
        return msb;
    }

}
