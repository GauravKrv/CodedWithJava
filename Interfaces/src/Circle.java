public class Circle implements InterfaceAreaCalculation{
    float r =2.0f;
        Circle(float r)
        {
           this.r = r;
        }
        @Override
        public float area() {
        float a=PI*r*r;
        return a;
        }

        public static void main(String[] args) {
        Circle c = new Circle(30);
        float res = c.area();
            System.out.println("Area = "+res +"mtrs square");
        }

}
