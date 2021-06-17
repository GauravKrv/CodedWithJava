public class Hello{
    int name;
    Hello (int name){
        this.name = name;
    }


    void Helloz(){   //METHOD
       name = 200;
    }
    int Hello2(){   //METHOD
       return name;
    }

    Hello (){
        System.out.println("jhsdbs");
    }

    public static void main(String[] args) {

        int a = 20;
        Hello h1 = new Hello(44);
        h1.Helloz();

        h1.name =30;
        a=99;
        System.out.println(h1.name);

    }

}
