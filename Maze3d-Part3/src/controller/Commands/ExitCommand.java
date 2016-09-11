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
	 * the function call to method Exit from MyModel
	 * in method Exit we closed all the threads are working and close the Program
	 */
	@Override
	public void doCommand(String[] args) {
		// TODO Auto-generated method stub
		model.Exit();
	}

}


