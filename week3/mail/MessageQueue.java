import java.util.LinkedList;
import java.util.ListIterator;

/**
   A first-in, first-out collection of messages. This
   implementation is not very efficient. We will consider
   a more efficient implementation in chapter 3.
*/
public class MessageQueue
{
   /**
      Constructs an empty message queue.
   */
   public MessageQueue()
   {
      queue = new LinkedList<Message>();
   }
   
   /**
    * Deletes a message from the MessageQueue
    * @param message message from MessageQueu
    */
   public void delete(Message message)
   {
	   queue.remove(message);
   }

   /**
      Remove message at head.
      @return message that has been removed from the queue
   */
   public Message remove()
   {
      return queue.remove(0);
   }

   /**
      Append message at tail.
      @param newMessage the message to be appended
   */
   public void add(Message newMessage)
   {
      queue.add(newMessage);
   }

   /**
      Get the total number of messages in the queue.
      @return the total number of messages in the queue
   */
   public int size()
   {
      return queue.size();
   }

   /**
      Get message at head.
      @return message that is at the head of the queue, or null
      if the queue is empty
   */
   public Message peek()
   {
      if (queue.size() == 0) return null;
      else return queue.get(0);
   }
   
   /**
    * @param Input index
    * @return Returns string of element, given it's index
    */
   public String getStr(Integer c)
   {
	   return queue.get(c).getText();
   }
   
   /**
     Print Linked List
     @return returns a printed list
   */
   public String printList()
   {
	   String output = "";
	   Integer c = 0;
	   ListIterator<Message> iterator = queue.listIterator();
	   while (iterator.hasNext())
	   {
		   output += queue.get(c).getText();
		   output += "\n";
		   c++;
		   iterator.next();
	   }
	   return output;
   }

   private LinkedList<Message> queue;
}
