package controller.Commands;

import controller.Command;
import model.Model;

/**
 * <h1>LoadMazeCommand</h1>
 * @author Stas Fainberg
 * @version 1.0
 * 
 */
public class LoadMazeCommand implements Command {
	
	
	/**************************** Data Members  ****************************/ 

	Model model;
	
	/**************************** Constructor  ****************************/ 

	public LoadMazeCommand(Model model) {
		this.model = model;
	}
	
	
	/******************************* doCommand() *****************************/
	/**
	 * This doCommand() method located in the LoadMazeCommand class which is implementing the Command interface.
	 * Executing this method will call the loadMaze() method located in the Model interface.
	 * <h1></h1>
	 * loadMaze() method can be implemented in any version by just implementing the Model interface.
	 */
	@Override
	public void doCommand(String[] args) {
		model.loadMaze();
	}

}
