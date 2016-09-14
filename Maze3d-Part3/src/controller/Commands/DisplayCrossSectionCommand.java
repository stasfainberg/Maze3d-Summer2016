package controller.Commands;

import controller.Command;
import model.Model;

/**
 * <h1>DisplayCrossSectionCommand</h1>
 * @author Stas Fainberg
 * @version 1.0
 * 
 */
public class DisplayCrossSectionCommand implements Command{

	/******************************* Data Members **************************/

	Model model;
	
	/******************************* Constructors **************************/

	public DisplayCrossSectionCommand(Model model) {
		this.model = model;
	}
	
	/************************* doCommand() ***********************/
	/**
	 * This doCommand() method located in the DisplayCrossSectionCommand class which 
	 * is implementing the Command interface.
	 * Executing this method will call the displayCroosSection() method located in the Model interface.
	 * <h1></h1>
	 * displayCroosSection() method can be implemented in any version by just implementing the Model interface.
	 */
	@Override
	public void doCommand(String[] args) {
		model.displayCroosSection();
	}

}
