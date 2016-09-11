package controller.Commands;

import controller.Command;
import model.Model;

/**
 * *********** the Class DisplaySolutionCommand ***************
 * @author Stas Fainberg and Idan Levy
 * @version 1.0
 * 
 */
public class DisplaySolutionCommand implements Command {

	Model model;
	
	/**
	 * Constructor of DisplaySolutionCommand
	 */
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
