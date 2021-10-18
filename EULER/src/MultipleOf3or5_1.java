public class MultipleOf3or5_1 {
    static int mul3Or5() {
        int limit = 1000;
        int sum = 0, mul3 = 3, mul5 = 5;
        int i = 2;
        while (mul3 < limit) {
            if (mul3 % 5 != 0) {
                sum += mul3;
            }
            mul3 =3 * i++;
        }
        i = 2;
        while (mul5 < limit) {
            sum += mul5;
            mul5 = 5 * i++;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(mul3Or5());//below 1000; -
        //Use AP - O(1)
    }
}
