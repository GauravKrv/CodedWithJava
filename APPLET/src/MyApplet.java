import java.applet.Applet;
import java.awt.*;

public class MyApplet extends Applet {

    @Override
    public void paint(Graphics g) {
        String data = getParameter("xyz");
        g.drawString(data,100,100);
    }
}
