import java.applet.Applet;
import java.awt.*;

public class AnimApplet extends Applet {
    Image img;

    @Override
    public void init() {
        img = getImage(getDocumentBase(),"img.png");
    }

    @Override
    public void paint(Graphics g) {
        //to checdk img is able to display properly or not
        g.drawImage(img,100,100,this);//whether y img is able to load succ or not we use img observer
  //By using ths, i say that i am not intrested un this feature
   for (int i =0;i<500;i++){ //If we want to move a content from the specified postion to another
       g.drawImage(img,i,100,this);
       try{
           Thread.sleep(20);
       }catch (InterruptedException e){
           e.printStackTrace();
       }
   }

    }
}
