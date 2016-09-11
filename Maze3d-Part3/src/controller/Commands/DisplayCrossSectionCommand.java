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
	 * This function displays cross section of the maze3d as a 2Dmaze.
	 * by calling to method displayCroosSection() from MyModel
	 * the function displayCroosSection() display the cross section (x/y/z) by index
	 */
	@Override
	public void doCommand(String[] args) {
		model.displayCroosSection();
	}

}
