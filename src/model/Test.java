package model;
import view.Gui;
import controller.LiftController;


public class Test {
	static Person person;
	static Floor floor;
	static Lift lift;
	static Button button;

	public static void main(String[] args) {
		
		Gui start = new Gui();
		LiftModel model = new LiftModel();
		LiftController controller = new LiftController(start, model);
		start.setVisible(true);
		controller.setVisible(true);
	}
}
