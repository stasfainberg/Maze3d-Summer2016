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
	 * the function display maze solution
	 * @param args - Arguments -> args[0] - Name of the maze.
	 */
	@Override
	public void doCommand(String[] args){

		model.displaySolution();
	}

}
