package controller.Commands;

import controller.Command;
import model.Model;

/**
 * <h1>SolveCommand</h1>
 * @author Stas Fainberg
 * @version 1.0
 * 
 */

public class SolveCommand implements Command {

	/**************************** Data Members  ****************************/ 

	Model model;
	
	/**************************** Constructor  ****************************/ 
	public SolveCommand(Model model) {
		super();
		this.model = model;
	}
	
	/************************* doCommand() ***********************/
	/**
	 * This doCommand() method located in the SolveCommand class which is implementing the Command interface.
	 * Executing this method will call the solveMaze() method located in the Model interface.
	 * <h1></h1>
	 * solveMaze() method can be implemented in any version by just implementing the Model interface.
	 * @param args - Arguments:
	 */
	@Override
	public void doCommand(String[] args) {
		model.solveMaze();
	}

}
