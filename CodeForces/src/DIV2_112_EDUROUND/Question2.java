package DIV2_112_EDUROUND;


public class Question2 extends CodeForces{
    public static void main (String[] args) throws java.lang.Exception
    {
        int t=I();
        while(t-->0)
        {
            int W=I(),H=I();
            int x1=I(),y1=I(),x2=I(),y2=I();
            int w=I(),h=I();
            int ans=MAX;
            if(x2-x1+w<=W){
                ans=Math.min(Math.max(0,w-x1),Math.max(0,w-(W-x2)));
            }
            if(y2-y1+h<=H){
                ans=Math.min(ans,Math.min(Math.max(0,h-y1),Math.max(0,h-(H-y2))));
            }
            if(ans==MAX)out.println("-1");
            else out.println(ans);
        }
        out.close();
    }
}
