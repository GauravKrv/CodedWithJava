import java.applet.Applet;

public class AppletBasics {
    /*
    1.INTRODUCTION : Applet is a special typeof program that is embedded in the webpage to
    generate the dynamic content. It runs inside the browser and works at client side.

    When james goseling designed java language,people were not using java in that much amt,
    as they alread had C/C++ by then which were comfortable enough.

    Sun microsystems were doing a featuer in java which will help to do some graphical progs in java
    As at that time the progrmiing languages had very less graohical programming things

    So it came with two things
    1)Some thing which allows to create graphical program : Applet
    2)Some thing where we can run this applet : Appletwear

    Later the browsers also suppported applet i.e there we can run Applet now

    Now in 2017-2018 java dropped the use of Applet, so it is not a relevant topic
    to learn.It is now a part of legacy classes

    Why applet became legacy class?

    2.WHY APPLET:
    Applet can do following things :
    1)Draw pictures on a webpage
    2)Play Sounds
    3)Receiv e input from the user through keyboard or the mouse
    4)Make a network connection to the serverr from which it came and can send to and receive
    arbitary data from that server only.

    3.LIMITATIONS OF APPLET
    1)Applet cannot access anything client resoyrces such as local file system
    executable files, system clipboards and printers
    2)They cannot connect to or retriev res from any 3rd party server(any server other thna
    the server it originated from)

    4.DIFFERENCE BETWEEN APPLICATION AND APPLET:
    1)Normally an application contains a main method so we can compile an app and run it.
    In case of an Applet, it does not hve ny maon method and becoz
    we dont have any main method so we cannot run it on an ide as we do with other
    java program.
    So an applet needs to be run on a webbrowser
    Whereas an application can run on the ide

    2)When we need to do something graphical-applet is needed
    When we need to solve a problem then application is used.

    5.LIFECYCLE OF APPLET:


    * * */
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
class AppletsGraphic extends Applet{

}
