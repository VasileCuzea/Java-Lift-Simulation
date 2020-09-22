package view;
import java.awt.Color;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;



import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.LiftController;
import model.Observer;
import model.Person;
import model.Door;
import model.Lift;

public class Gui extends JFrame implements Observer{

private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JLabel label;
	
	private JButton buttonTestCase1 = new JButton("Test Case 1");
	private JButton buttonTestCase2 = new JButton("Test Case 2");
	private JButton buttonTestCase3 = new JButton("Test Case 3");

	private int person;
	
	private final int liftTravelTime = 5000; //lift moving up or down for 5 seconds;
	private final int doorsOpenTime = 1000; //doors open for 1 second;

	 DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"); //https://beginnersbook.com/2013/05/current-date-time-in-java/
	 Calendar calobj = Calendar.getInstance();
	 
	 
	//Constructor
	public Gui() {
		
		//creating the frame
        this.setTitle("Vasile Cuzea LiftSimulation");
        this.setSize(800, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       
        //creating the label for background image
        label = new JLabel();
        
        //setting the size of the panel
        panel = new JPanel();
        panel.setSize(800,800);

        //adding background colour to the panel
        panel.setBackground(Color.LIGHT_GRAY);   
        
        //adding the three test case buttons to the panel
        panel.add(buttonTestCase1);           
        panel.add(buttonTestCase2);     
        panel.add(buttonTestCase3);
        
        //adding background image to GUI
        label.setIcon(new ImageIcon("C:\\UNI\\Y3\\AdvancedProgramming\\LiftSimulationAssignment\\b3.png"));       
        
        //Adding the background image to the panel
        panel.add(label);
        
        // Adding the panel to the JFrame        
        this.add(panel);              
	}
	
	
	public void update(Object o, int event) {		
		if(o instanceof Person) {
			 person = ((Person) o).getpersonId();
			personStatus(event);			
		}		
		else if(o instanceof Lift) {			
			liftStatus(event);
		}		
		else if(o instanceof Door) {	
			doorStatus(event);
		}
	}

		
		//person status
		public void personStatus(int status) {			
		if(status == 0) {		
			System.out.println(df.format(Calendar.getInstance().getTime()) + "   " + "Person id: " + person + " created.");			
		}		
		else if(status == 1) {				
			System.out.println(df.format(Calendar.getInstance().getTime()) + "   " + "Person is pressing the button on the " + floorLocation(0));				
			}
		else if(status == 2) {				
			System.out.println(df.format(Calendar.getInstance().getTime()) + "   " + "Person is pressing the button on the " + floorLocation(1));				
		}	
		else if(status == 3) {			 
			System.out.println(df.format(Calendar.getInstance().getTime()) + "   " + "Person is entering the lift.");			
		}		
		else if(status == 4) {			
			System.out.println(df.format(Calendar.getInstance().getTime()) + "   " + "Person is pressing the button in the lift.");			
		}		
		else {			
			System.out.println(df.format(Calendar.getInstance().getTime()) + "   " + "Person exiting the lift.");						
		}	
	}
		
		
		//lift status
		public void liftStatus(int status) {
			if (status == 0){				
				System.out.println(df.format(Calendar.getInstance().getTime()) + "   " + "Lift arrived: " + floorLocation(0));				
			}
			else if (status == 1){				
				System.out.println(df.format(Calendar.getInstance().getTime()) + "   " + "Lift arrived: " + floorLocation(1));				
			}
			else {					
				try {
					System.out.println(df.format(Calendar.getInstance().getTime()) + "   " + "Lift departed for: " + liftTravelTime + " milliseconds.");
					
					Thread.sleep(liftTravelTime);
					}					
					catch(InterruptedException exception)
					{
						System.out.println("Lift departed");
					}					
				}
			}

		
		//door status
		public void doorStatus(int status) {		
			if (status == 0){				
				System.out.println(df.format(Calendar.getInstance().getTime()) + "   " + "Doors closed.");				
			}			
			else {				
				try {
					System.out.println(df.format(Calendar.getInstance().getTime()) + "   " + "Doors open for: " + doorsOpenTime + " milliseconds.");					
					Thread.sleep(doorsOpenTime);				
					}					
					catch(InterruptedException exception)
					{
						System.out.println(doorsOpenTime);
					}					
				}
			}
		
		
		//button location
		public void buttonLocation(int buttonLocation) {
			if(buttonLocation == 0){				
				System.out.println(df.format(Calendar.getInstance().getTime()) + "   " + "Up button created on Ground Floor.");
			}			
			else if(buttonLocation == 1) {				
				System.out.println(df.format(Calendar.getInstance().getTime()) + "   " + "Down button created on First Floor.");
			}			
			else {				
				System.out.println(df.format(Calendar.getInstance().getTime()) + "   " + "Button created in the lift.");
			}
		}
		
		
		//floorLocation
		public String floorLocation(int location) {			
		if(location == 0) {				
			return "Ground Floor.";				
		}			
		else {				
		return "First Floor.";			
		  }		
		}
		
		
		//implementing listener for test case buttons
		public void addListener(LiftController.LiftSimulationListener listenForTestCaseButtons) {		
		buttonTestCase1.addActionListener(listenForTestCaseButtons); 
		buttonTestCase2.addActionListener(listenForTestCaseButtons);
		buttonTestCase3.addActionListener(listenForTestCaseButtons); 
	}
	
	
	//getters for test case buttons	used in the Controller class
	  public JButton getTestCase1Btn() {		
  		return buttonTestCase1;
  	}
	
      public JButton getTestCase2Btn() {
  		return buttonTestCase2;
  	}
      
      public JButton getTestCase3Btn() {
  		return buttonTestCase3;
  	}		
	
	
}
