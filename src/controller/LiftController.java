package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import view.Gui;
import model.LiftModel;


public class LiftController {
	
	private Gui gui;	
	private LiftModel model;
	
	public LiftController (Gui gui, LiftModel model){	
		this.gui = gui;
		this.model = model;
		this.gui.addListener(new LiftSimulationListener());
	}

	
	public class LiftSimulationListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			
			if (event.getSource() == gui.getTestCase1Btn()) {
				System.out.println("TEST CASE 1:");
				
				model.createPerson(0);	
				gui.personStatus(1);
				gui.doorStatus(1);			
				gui.personStatus(3);
				gui.personStatus(4);
				gui.doorStatus(0);
				gui.liftStatus(2);
				gui.liftStatus(1);
				gui.doorStatus(1);
				gui.personStatus(5);				
				System.out.println("\n");				
		}
			
			else if (event.getSource() == gui.getTestCase2Btn()) {		
				System.out.println("TEST CASE 2:");
				
				model.createPerson(1);
				gui.personStatus(1);
				gui.liftStatus(2);
				gui.liftStatus(0);
				gui.doorStatus(1);
				gui.personStatus(3);
				gui.personStatus(4);
				gui.doorStatus(0);
				gui.liftStatus(2);
				gui.liftStatus(1);
				gui.doorStatus(1);
				gui.personStatus(5);				
				System.out.println("\n");				
			}
			
			else  {
				System.out.println("TEST CASE 3:");
				model.createPerson(1);	
				gui.personStatus(2);
				gui.doorStatus(1);			
				gui.personStatus(3);
				gui.personStatus(4);
				gui.doorStatus(0);
				gui.liftStatus(2);
				gui.liftStatus(0);
				gui.doorStatus(1);
				gui.personStatus(5);
				model.createPerson(0);
				gui.personStatus(1);
				gui.personStatus(3);
				model.createPerson(0);		
				gui.personStatus(3);
				model.createPerson(0);
				gui.personStatus(3);
				gui.personStatus(4);
				gui.doorStatus(0);	
				gui.liftStatus(2);
				gui.liftStatus(1);
				gui.personStatus(5);
			}
		}		
	}		

	public void setVisible(boolean visible) {	
		
	}
}
