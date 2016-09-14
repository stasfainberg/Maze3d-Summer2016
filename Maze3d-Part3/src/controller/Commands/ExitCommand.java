package controller.Commands;

import controller.Command;
import model.Model;

/**
 * <h1>ExitCommand</h1>
 * @author Stas Fainberg
 * @version 1.0
 * 
 */
public class ExitCommand implements Command {

	/******************************* Data Members **************************/

	private Model model;

	/******************************* Constructors **************************/

	public ExitCommand(Model model) {
		super();
		this.model = model;
	}



	/************************* doCommand() ***********************/
	/**
	 * This doCommand() method located in the ExitCommand class which is implementing the Command interface.
	 * Executing this method will call the Exit() method located in the Model interface.
	 * <h1></h1>
	 * Exit() method can be implemented in any version by just implementing the Model interface.
	 */
	@Override
	public void doCommand(String[] args) {
		// TODO Auto-generated method stub
		model.exit();
	}

}


