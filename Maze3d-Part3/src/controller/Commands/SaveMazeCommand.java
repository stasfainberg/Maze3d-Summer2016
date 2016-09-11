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

	@Override
	public void doCommand(String[] args) {
	
		model.saveMaze();
	}

}

