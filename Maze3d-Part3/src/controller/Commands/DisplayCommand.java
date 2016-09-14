package controller.Commands;

import controller.Command;
import model.Model;


/**
 * <h1>DisplayCommand</h1>
 * @author Stas Fainberg
 * @version 1.0
 * 
 */
public class DisplayCommand implements Command {

	
	/******************************* Data Members **************************/

	Model model;
	
	/******************************* Constructors **************************/

	public DisplayCommand(Model model) {
		this.model = model;
	}
	
	/******************************* Methods **************************/
	/**
	 * This doCommand() method located in the DisplayCommand class which is implementing the Command interface.
	 * Executing this method will call the display() method located in the Model interface.
	 * <h1></h1>
	 * display() method can be implemented in any version by just implementing the Model interface.
	 */
	@Override
	public void doCommand(String[] args) {
		model.display();
	}

}
