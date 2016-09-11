package controller.Commands;

import controller.Command;
import model.Model;

/**
 * *********** the Class DisplayCrossSectionCommand ***************
 * @author Stas Fainberg and Idan Levy
 * @version 1.0
 * 
 */
public class DisplayCrossSectionCommand implements Command{

	Model model;
	
	/**
	 * Constructor of DisplayCrossSectionCommand
	 */
	public DisplayCrossSectionCommand(Model model) {
		this.model = model;
	}
	
	/************************* doCommand() ***********************/
	/**
	 * the function display cross section of the 3Dmaze as a 2Dmaze 
	 * by calling to method displayCroosSection() from MyModel
	 * the function displayCroosSection() display the cross section (x/y/z) by index
	 */
	@Override
	public void doCommand(String[] args) {
		model.displayCroosSection();
	}

}
