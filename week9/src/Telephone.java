import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.applet.Applet;
import java.awt.GridBagLayout;

/**
   Presents a phone GUI for the voice mail system.
*/
public class Telephone extends Applet
{
   /**
      Constructs a telephone with a speaker, keypad,
      and microphone.
   */
   public Telephone()
   {
	  
	   JFrame telephoneFrame = new JFrame("GridBagLayoutDemo");
	   telephoneFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       addComponentsToPane(telephoneFrame.getContentPane());
       telephoneFrame.pack();
       telephoneFrame.setVisible(true);
       
   }
   
   final static boolean shouldFill = true;
   final static boolean shouldWeightX = true;
   final static boolean RIGHT_TO_LEFT = false;

   private static final int BUTTONS_WIDTH = 3;
   private static final int BUTTONS_HEIGHT = 4;
   
   public static void addComponentsToPane(Container pane) {
       if (RIGHT_TO_LEFT) {
           pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
       }

       JButton panelButton;
       JLabel panelLabel;
       JTextArea panelTextArea;
       
       pane.setLayout(new GridBagLayout());
       GridBagConstraints c = new GridBagConstraints();
       c.fill = GridBagConstraints.HORIZONTAL;
       
       int gridY = 0;

       c.gridwidth = 3;
       
       panelLabel = new JLabel("Speaker:");
       c.gridx = 0;
       c.gridy = gridY++;
       pane.add(panelLabel, c);
     
       panelTextArea = new JTextArea(10,10);
       c.gridx = 0;
       c.gridy = gridY++;
       pane.add(panelTextArea, c);
       
       
       
       String values[][] = {
    		   {"1", "2", "3"},
    		   {"4", "5", "6"},
    		   {"7","8","9"},
    		   {"*","0","#"}
       };
       
       c.gridwidth = 1;
       for (int i = 0; i < BUTTONS_HEIGHT; i++)
       {
    	   for (int j = 0; j < BUTTONS_WIDTH; j++)
    	   {
    		   panelButton = new JButton(values[i][j]);
    		   c.gridx = j;
    		   c.gridy = gridY;
    		   pane.add(panelButton, c);
    	   }
    	   gridY++;
       }
       c.gridwidth = 3;
       
       panelLabel = new JLabel("Microphone:");
       c.gridx = 0;
       c.gridy = gridY++;
       pane.add(panelLabel, c);
     
       panelTextArea = new JTextArea(10,10);
       c.gridx = 0;
       c.gridy = gridY++;
       pane.add(panelTextArea, c);

       c.gridx = 0;
       c.gridy = gridY++;
       JPanel actions = new JPanel();
       actions.setLayout(new BorderLayout());
       actions.add(new JButton("rawr"), BorderLayout.WEST);
       actions.add(new JButton("rawr2"), BorderLayout.EAST);
       pane.add(actions, c);
       
   }
   
   protected void makebutton(String name, GridBagLayout gridbag, GridBagConstraints c, JPanel panel)
   {
 	  Button button = new Button(name);
 	  gridbag.setConstraints(button, c);
 	  add(button);
   }
		   
/*		  
      JPanel speakerPanel = new JPanel();
      speakerPanel.setLayout(new BorderLayout());
      speakerPanel.add(new JLabel("Speaker:"),
            BorderLayout.NORTH);
      speakerField = new JTextArea(10, 25);
      speakerPanel.add(speakerField,
            BorderLayout.CENTER);

      String keyLabels = "123456789*0#";
      JPanel keyPanel = new JPanel();
      keyPanel.setLayout(new GridLayout(4, 3));
      for (int i = 0; i < keyLabels.length(); i++)
      {
         final String label = keyLabels.substring(i, i + 1);
         JButton keyButton = new JButton(label);
         keyPanel.add(keyButton);
         keyButton.addActionListener(new
            ActionListener()
            {
               public void actionPerformed(ActionEvent event)
               {
                  connect.dial(label);
               }
            });
      }
      
     

      final JTextArea microphoneField = new JTextArea(10,25);

      JButton speechButton = new JButton("Send speech");
      speechButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               connect.record(microphoneField.getText());
               microphoneField.setText("");
            }
         });

      JButton hangupButton = new JButton("Hangup");
      hangupButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               connect.hangup();
            }
         });

      JPanel buttonPanel = new JPanel();
      buttonPanel.add(speechButton);
      buttonPanel.add(hangupButton);

      JPanel microphonePanel = new JPanel();
      microphonePanel.setLayout(new BorderLayout());
      microphonePanel.add(new JLabel("Microphone:"),
            BorderLayout.NORTH);
      microphonePanel.add(microphoneField, BorderLayout.CENTER);
      microphonePanel.add(buttonPanel, BorderLayout.SOUTH);

      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.add(speakerPanel, BorderLayout.NORTH);
      frame.add(keyPanel, BorderLayout.CENTER);
      frame.add(microphonePanel, BorderLayout.SOUTH);

      frame.pack();
      frame.setVisible(true);
   }*/

   /**
      Give instructions to the mail system user.
   */
   public void speak(String output)
   {
      speakerField.setText(output);
   }

   public void run(Connection c)
   {
      connect = c;
   }

   private JTextArea speakerField;
   private Connection connect;
}