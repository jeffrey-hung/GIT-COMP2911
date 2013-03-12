public class GreeterTester
{
   public static void main(String[] args)
   {
      Greeter worldGreeter = new Greeter("World");
      Greeter daveGreeter = new Greeter("Dave");

      System.out.println("#Testing output of 'Hello' for world greeter");
      String greeting = worldGreeter.sayHello();
      System.out.println(greeting);

      /* Reseting and Printing Names */
      System.out.println("#Reset name of world greeter to 'Earth'");
      worldGreeter.setName("Earth");
      greeting = worldGreeter.sayHello();
      System.out.println(greeting);

      System.out.println("#Repeat sayHello(), but for daveGreeter");
      greeting = daveGreeter.sayHello();
      System.out.println(greeting);

      /* Playing with pointers */
      System.out.println("#Assign worldGreeter to daveGreeter");
      daveGreeter = worldGreeter;

      System.out.println("#Print daveGreeter");
      greeting = daveGreeter.sayHello();
      System.out.println(greeting);

      System.out.println("#Set daveGreeter name to be 'Janet'");
      daveGreeter.setName("Janet");

      System.out.println("#Print worldGreeter - should be 'Janet'");
      greeting = worldGreeter.sayHello();
      System.out.println(greeting);

      System.out.println("#All tests passed");
   }
}

/*

--Excercise 2--

Point 4:

Greeter worldGreeter (AND) Greeter daveGtreeter ->
-- Instance 1 of class Greeter
---- Method "sayHello"
---- Method "setName"
---- Field "name"

Point 7:
After daveGreeter = worldGreeter, and a call to daveGreeter.setName("Janet"), output of worldGreeter.sayHello() should be "Janet"

*/
