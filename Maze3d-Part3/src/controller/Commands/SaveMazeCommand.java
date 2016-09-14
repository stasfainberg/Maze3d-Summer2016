package controller.Commands;

import controller.Command;
import model.Model;

/**
 * <h1>SaveMazeCommand</h1>
 * @author Stas Fainberg
 * @version 1.0
 * 
 */
public class SaveMazeCommand implements Command {

	
	/**************************** Data Members  ****************************/ 

	private Model model;
	
	
	/**************************** Constructor  ****************************/ 
	
	public SaveMazeCommand(Model model) {
		this.model = model;
	}
	
	/************************* doCommand() ***********************/
	/**
	 * This doCommand() method located in the SaveMazeCommand class which is implementing the Command interface.
	 * Executing this method will call the saveMaze() method located in the Model interface.
	 * <h1></h1>
	 * saveMaze() method can be implemented in any version by just implementing the Model interface.
	 */
	@Override
	public void doCommand(String[] args) {
		model.saveMaze();
	}

}

