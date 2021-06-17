import java.util.Scanner;

public class ValidUsernameEpression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a valid user name  : ");
            char str[] = sc.next().toCharArray();
        boolean flag = true;
        if ((str.length>=8
                &&str.length<=30
                && (((int)str[0] >64 && (int)str[0] < 91) ||( (int)str[0]>96 && (int)str[0] <123))
        )){
            for (int i = 0; i < str.length; i++) {
                  if (((int) str[i] > 64 && (int) str[i] < 91) || ((int) str[i] > 96 && (int) str[i] < 123) || (int) str[i] == 95 || ((int) str[i] > 47 && (int) str[i] < 58)) {

                  }else {
                      flag = false;
                      break;

                  }
            }
        }else {
            flag = false;
        }

        if (flag == true){
            System.out.println("Correct Username!!");
        }else{
            System.out.println("Invalid Username!!");

        }
    }
}
