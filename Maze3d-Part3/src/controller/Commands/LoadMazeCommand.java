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

	@Override
	public void doCommand(String[] args) {
		model.loadMaze();
	}

}
