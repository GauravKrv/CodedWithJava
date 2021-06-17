public class InterfaceClass  {
  /*  Class             Interfaces                              Abstract
   1] concrete Methods    abstract Methods                         concrete/abstract Methods
   2] concrete class     interface                                abstact class
   3] var/final vars     only has final variables(constants)       var/final vars
                    --> BY DEFAULT THE VARS AND METHODS OF
                        Interface is final and abstract
                        So if we want to use an interace then
                        we are bound to use it as it is
                    -->It is heavily restricted in comprsn with abstract class

       INTERFACES:
      1] Why?- When we want to give specific structure to child, We can also
      achieve mulltiple inheritance feature through interface but this is not the main rsn of
      having an interface.
      2]Use Cases:To create an API using which our employees can implement the functions
      of that class from their own ideas or
      --but in API both concrete+abstrct methods are there.
      //Assignment--->API integeration for phonepay or google pay or any specific application
      e.g Using runnable interface of thread class
      3]In java the number of library interfaces are more than the nmber of lib classes
      as jva dont wants to follow a code structure  but wants us to follow the code
       4]PROPERTIES:
       a)Use a keyword "interface" to create an interface
       b)To inherit or use an interface then we have to write:
       "class implements interface"
       c)BY DEFAULT THE VARS AND METHODS OF Interface is ,final and abstract
       So if we want to use an interface then we are bound to use it as it is
       -->interface methods are also public because
       --if the base class having a restrictive access specifier then a child class has o be less
       restrictive or same restrictive than that.
       i.e any access specifier can use the interfacees. as the public has the highest priority
       of less restrictiveness.

        d)Data members are static ,final and public
        e)we cannot create object of interface but reference can be created.
        Assignment-2:::So what is the use of creating the reference of interface like
        the abstract class??
   */

}

