import java.applet.Applet;
import java.awt.*;

public class TestApplet extends Applet {
    //How can we say that it s a applet without seeing the name.
    //By extending Applet class
    //Paint method us sed ti print something


    @Override
    public void paint(Graphics g) { /*It takes the obj reference of Graphics class by Syntax,
        Why Graphics ? => I want to print or show my name in the web brwoser or appletViewer
         and not in the command prompt(so no use of System.out.print) so we have to use
         a method called drawString(),
          & for it i need its class's object reference by which i can use this method.
        */
        //To write any applet program we need two packages included in my program:
        //1)applet, 2)awt.*
        g.drawString("hello",20,20);//String, left margin, right margin
        System.out.println("hello");

    }

    /*
    ==>We need an older verson of jdk or appletviewer to run this else not possible.
    To run above program in cmd then we have to compile it first which will create a bytecode
    of it named TestApplet.class.
    =>We need an HTML file to run an Applet
    =>inside body tag we have to use applet tag to use TestApplet.class:
    <html>
    <head>
    </head>
    <body>
    <applet code="TestApplet.class" codebase="path of TestApplet.class" height=" " width=" " align = "centre"
     alt="msg if applet is not able to run the .class file">
     <param name = "" value = "">
......................body........
    </applet>
    </body>
    </html>

    name => xyz.html


    * * */
}
