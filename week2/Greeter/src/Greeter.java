/**
   A class for producing simple greetings.
*/

public class Greeter
{
   /**
      Constructs a Greeter object that can greet a person or 
      entity.
      @param aName the name of the person or entity who should
      be addressed in the greetings.
   */
   public Greeter(String aName)
   {
      this.name = aName;
   }

   /**
      Greet with a "Hello" message.
      @return a message containing "Hello" and the name of
      the greeted person or entity.
   */
   public String sayHello()
   {
      return "Hello, " + name + "!";
   }

   /**
      Set new custom name
      @param aName name of person/entity who should be addressed in  the greetings
   */
   public void setName(String aName)
   {
      this.name = aName;
   }

   private String name;
}

