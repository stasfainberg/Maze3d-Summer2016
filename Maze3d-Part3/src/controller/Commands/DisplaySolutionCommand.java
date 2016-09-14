package controller.Commands;

import controller.Command;
import model.Model;

/**
 * <h1>DisplaySolutionCommand</h1>
 * @author Stas Fainberg
 * @version 1.0
 * 
 */
public class DisplaySolutionCommand implements Command {

	/******************************* Data Members **************************/

	Model model;
	
	/******************************* Constructors **************************/

	public DisplaySolutionCommand(Model model) {
		super();
		this.model = model;
	}

	/************************* doCommand() ***********************/
	/**
	 * This doCommand() method located in the DisplaySolutionCommand class which 
	 * is implementing the Command interface.
	 * Executing this method will call the displaySolution() method located in the Model interface.
	 * <h1></h1>
	 * displaySolution() method can be implemented in any version by just implementing the Model interface.
	 */
	@Override
	public void doCommand(String[] args){

		model.displaySolution();
	}

}
