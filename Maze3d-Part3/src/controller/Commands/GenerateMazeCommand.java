package controller.Commands;

import controller.Command;
import model.Model;



/**
 * <h1>GenerateMazeCommand</h1>
 * @author Stas Fainberg
 * @version 1.0
 * 
 */
public class GenerateMazeCommand implements Command {
	
	
	/******************************* Data Members **************************/

	private Model model;
	
	
	/******************************* Constructors **************************/

	public GenerateMazeCommand(Model model) {
		this.model = model;
	}	
	
	
	/******************************* Methods **************************/
	/**
	 * This doCommand() method located in the GenerateMazeCommand class which is implementing the Command interface.
	 * Executing this method will call the GenerateMazeCommand() method located in the Model interface.
	 * <h1></h1>
	 * GenerateMazeCommand() method can be implemented in any version by just implementing the Model interface.
	 */
	@Override
	public void doCommand(String[] args) {
	
		model.generateMaze();
	}

	
	
	
	
	
	
}
